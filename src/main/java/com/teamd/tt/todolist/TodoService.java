package com.teamd.tt.todolist;

import com.teamd.tt.todolist.model.dto.*;
import com.teamd.tt.todolist.model.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    @Transactional
    public int insTravelInfo(InsDto dto) {
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
            e.printStackTrace();
            return 1;
        }

        String subList = "";
        List<InsCheckListVo> checkList;

        for (int i = 0; i < dto.getSubList().size(); i++) {
            subList = dto.getSubList().get(i).getSubTitle();

            try {
                mapper.insSubTitle(subList);
            } catch (Exception e) {
                e.printStackTrace();
                return 2;
            }

            if (dto.getSubList().get(0).getCheckList().size() == 0) {
                return 4;
            }

            try {
                checkList = dto.getSubList().get(i).getCheckList();
                mapper.insCheckList(checkList);
            } catch (Exception e) {
                e.printStackTrace();
                return 3;
            }
        }
        return 0;
    }

    public SelPickInfo selPickInfo(int idTitle) {
        SelPickInfo pickInfo;
        List<SelSubTitleListVo> list = mapper.selPickTravelInfoDetail(idTitle);

        pickInfo = mapper.selPickTravelInfo(idTitle);
        pickInfo.setSubList(list);
        return pickInfo;
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


//        public int updTitle (updTitleEntity entity){
//            String idRegion = mapper.selIdRegion(entity.getIdRegion());
//            String idRegionDetail = mapper.selIdRegionDetail(entity.getIdRegionDetail());
//            entity.setTitle(idRegion + " " + idRegionDetail);
//            return mapper.updTitle(entity);
//        }
//
//        public int updSubTitle (updSubTitleEntity entity){
//            return mapper.updSubTitle(entity);
//        }
}
