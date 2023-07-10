package com.teamd.tt.todolist;

import com.teamd.tt.todolist.model.dto.*;
import com.teamd.tt.todolist.model.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TodoService {
    private final TodoMapper mapper;

    @Autowired
    public TodoService(TodoMapper mapper) {
        this.mapper = mapper;
    }

    public SelRegionAllVo selRegion() {
        List<SelRegionVo> dto = mapper.selRegion();
        List<SelRegionDetailVo> dto1 = mapper.selDetailRegion();

        return SelRegionAllVo.builder()
                .region(dto)
                .regionDetail(dto1)
                .build();
    }

    @Transactional(rollbackFor = Exception.class)
    public int insTravelInfo(InsDto dto) throws Exception {
        InsTitleDto titleDto = new InsTitleDto();
        titleDto.setIdRegionDetail(dto.getIdRegionDetail());
        titleDto.setIdRegion(dto.getIdRegion());

        String idRegion = mapper.selIdRegion(dto.getIdRegion());
        String idRegionDetail = mapper.selIdRegionDetail(dto.getIdRegionDetail());
        titleDto.setTitle(idRegion + " " + idRegionDetail);

        titleDto.setStartDate(dto.getStartDate());
        titleDto.setEndDate(dto.getEndDate());
        titleDto.setCalColor(dto.getCalColor());

        //travel테이블 insert 에러체크
        try {
            mapper.insTitle(titleDto);
        } catch (Exception e) {
            throw new Exception("오류 코드 : 1번");
        }

        String subList = "";
        List<InsCheckListVo> checkList;

        for (int i = 0; i < dto.getSubList().size(); i++) {
            subList = dto.getSubList().get(i).getSubTitle();

            try {
                mapper.insSubTitle(subList);
            } catch (Exception e) {
                throw new Exception("오류 코드 : 2번");
            }

            if (dto.getSubList().get(i).getCheckList().size() == 0) {
                continue;
            }

            try {
                checkList = dto.getSubList().get(i).getCheckList();
                mapper.insCheckList(checkList);
            } catch (Exception e) {
                throw new Exception("오류 코드 : 3번");
            }
        }
        return 1;
    }

    public SelPickInfo selPickInfo(int idTitle) {
        InfoDto dto = new InfoDto();
        dto.setIdTitle(idTitle);
        return mapper.selPickTravelInfo(dto);
    }
@Transactional(rollbackFor = Exception.class)
    public int updPickInfo(ModifyPickInfo pickInfo) {
        UpdDto2 dto2 = new UpdDto2();
        dto2.setIdTitle(pickInfo.getIdTitle());
        dto2.setIdRegionDetail(pickInfo.getIdRegionDetail());
        dto2.setIdRegion(pickInfo.getIdRegion());
        dto2.setStartDate(pickInfo.getStartDate());
        dto2.setEndDate(pickInfo.getEndDate());
        dto2.setCalColor(pickInfo.getCalColor());
        mapper.updTitle(dto2);


        InsSubTitleDto insSubTitleDto = new InsSubTitleDto();
        UpdSubTitleDto updSubTitleDto = new UpdSubTitleDto();
        InsCheckListDto insCheckListDto = new InsCheckListDto();
        UpdCheckListDto updCheckListDto = new UpdCheckListDto();

        int subListSize = pickInfo.getSubList().size();

        //subtitle, checklist테이블 업데이트
        for (int i = 0; i < subListSize; i++) {
            String getSubTitle = pickInfo.getSubList().get(i).getSubTitle();
            int getSubId = pickInfo.getSubList().get(i).getIdSub();
            boolean getSubFinishYn = pickInfo.getSubList().get(i).isFinishYn();
            
            if (getSubId == 0) {//새로생성된 서브리스트는 인서트
                insSubTitleDto.setIdTitle(pickInfo.getIdTitle());
                insSubTitleDto.setSubTitle(getSubTitle);
                insSubTitleDto.setFinishYn(getSubFinishYn);
                mapper.insSubTitle2(insSubTitleDto);
            }
            else if (getSubId >= 1) {//이미 있는 서브리스트는 업데이트
             updSubTitleDto.setIdSub(getSubId);
             updSubTitleDto.setSubTitle(getSubTitle);
             updSubTitleDto.setFinishYn(getSubFinishYn);
             mapper.updSubList(updSubTitleDto);
            }

            int checkListSize = pickInfo.getSubList().get(i).getCheckList().size();

            for (int j = 0; j < checkListSize; j++) {

                String getCheckTitle = pickInfo.getSubList().get(i).getCheckList().get(j).getCheckTitle();
                int getCheckId = pickInfo.getSubList().get(i).getCheckList().get(j).getIdCheck();
                boolean getCheckFinishYn = pickInfo.getSubList().get(i).getCheckList().get(j).isFinishYn();


                if (getCheckId == 0 && getSubId >= 1) {//sub가 존재할때 새로생성된 체크리스트 인서트
                    insCheckListDto.setIdSub(getSubId);
                    insCheckListDto.setCheckTitle(getCheckTitle);
                    insCheckListDto.setFinishYn(getCheckFinishYn);
                    mapper.insCheckList2(insCheckListDto);
                }
                if (getCheckId == 0 && getSubId == 0) {//새로생성된 sub안의 새로생성된 체크리스트 인서트
                    insCheckListDto.setIdSub(mapper.selLastSubId());
                    insCheckListDto.setCheckTitle(getCheckTitle);
                    insCheckListDto.setFinishYn(getCheckFinishYn);
                    mapper.insCheckList2(insCheckListDto);
                }
                else if (getSubId >= 1) {//조건을 전부거침 = 존재하는 체크리스트, 이미 있는 체크리스트는 업데이트
                    updCheckListDto.setIdCheck(getCheckId);
                    updCheckListDto.setCheckTitle(getCheckTitle);
                    updCheckListDto.setFinishYn(getCheckFinishYn);
                    mapper.updCheckList(updCheckListDto);
                }
            }
        }
        return 1;
    }


    public int delCheckList(DelCheckListDto dto) {
        return mapper.delCheckList(dto);
    }

    public int delSubTitle(DelSubTitleDto dto) {
        return mapper.delSubTitle(dto);
    }

    public int updTravel(UpdTravelDto dto) {
        return mapper.updTravel(dto);
    }
}
