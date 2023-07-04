package com.teamd.tt.todolist;

import com.teamd.tt.todolist.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TodoMapper mapper;

    @Autowired
    public TodoService(TodoMapper mapper) {
        this.mapper = mapper;
    }

    public SelRegionVoAll selRegion() {
        List<SelRegionVo> dto = mapper.selRegion();
        List<SelRegionDetailVo> dto1 = mapper.selDetailRegion();

        return SelRegionVoAll.builder()
                .region(dto)
                .regionDetail(dto1)
                .build();
    }

    public int insAddTitle(InsTitleDto dto) {
        InsTitleEntity entity = new InsTitleEntity();
        String idregion =mapper.selidRegion(dto.getIdRegion());
        String idregiondetail =mapper.selidRegionDetail(dto.getIdRegionDetail());
        entity.setTitle(idregion+" "+idregiondetail); // 남규진 콜
        entity.setIdRegion(dto.getIdRegion());
        entity.setIdRegionDetail(dto.getIdRegionDetail());
        entity.setStartDate(dto.getStartDate());
        entity.setEndDate(dto.getEndDate());
        entity.setCalColor(dto.getCalColor());
        return mapper.insAddTitle(entity);
    }

    public int insAddSubTitle( InsSubTitleDto dto) {
        return mapper.insAddSubTitle(dto);
    }

    public int insAddCheckList( InsCheckListDto dto) {
        return mapper.insAddCheckList(dto);
    }

    public int updTitle(updTitleDto dto) {
        updTitleEntity entity = new updTitleEntity();
        entity.set
        String idregion =mapper.selidRegion(dto.getIdRegion());
        String idregiondetail =mapper.selidRegionDetail(dto.getIdRegionDetail());
        entity.setTitle(idregion+" "+idregiondetail);
        entity.setIdRegion(dto.getIdRegion());
        entity.setIdRegionDetail(dto.getIdRegionDetail());
        entity.setStartDate(dto.getStartDate());
        entity.setEndDate(dto.getEndDate());
        entity.setCalColor(dto.getCalColor());
        return mapper.updTitle(entity);
    }

}
