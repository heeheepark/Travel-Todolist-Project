package com.teamd.tt.todolist;

import com.teamd.tt.todolist.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodoMapper {
    List<SelRegionVo> selRegion();
    List<SelRegionDetailVo> selDetailRegion();
    int insAddTitle(InsTitleEntity entity );
    String selIdRegion(int idRegion);
    String selIdRegionDetail(int idRegionDetail);
    int insAddSubTitle(InsSubTitleDto dto);
    int insAddCheckList(InsCheckListDto dto);
    int updTitle(updTitleEntity entity);
}
