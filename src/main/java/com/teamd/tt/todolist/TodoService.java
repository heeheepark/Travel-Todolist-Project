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
        String idregion = mapper.selIdRegion(dto.getIdRegion());
        String idregiondetail = mapper.selIdRegionDetail(dto.getIdRegionDetail());
        entity.setTitle(idregion + " " + idregiondetail); // 남규진 콜
        entity.setIdRegion(dto.getIdRegion());
        entity.setIdRegionDetail(dto.getIdRegionDetail());
        entity.setStartDate(dto.getStartDate());
        entity.setEndDate(dto.getEndDate());
        entity.setCalColor(dto.getCalColor());
        return mapper.insAddTitle(entity);
    }

    public int insAddSubTitle(InsSubTitleDto dto) {
        return mapper.insAddSubTitle(dto);
    }

    public int insAddCheckList(InsCheckListDto dto) {
        return mapper.insAddCheckList(dto);
    }

    public int updTitle(updTitleEntity entity) {
        String idRegion = mapper.selIdRegion(entity.getIdRegion());
        String idRegionDetail = mapper.selIdRegionDetail(entity.getIdRegionDetail());
        entity.setTitle(idRegion + " " + idRegionDetail);
        return mapper.updTitle(entity);
    }

    public int updSubTitle(updSubTitleEntity entity ) {
        return mapper.updSubTitle(entity);
    }
}
