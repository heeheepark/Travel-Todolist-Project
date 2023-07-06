package com.teamd.tt.todolist;

import com.teamd.tt.todolist.model.*;
import com.teamd.tt.todolist.model.dto.*;
import com.teamd.tt.todolist.model.vo.InsCheckListVo;
import com.teamd.tt.todolist.model.vo.SelRegionDetailVo;
import com.teamd.tt.todolist.model.vo.SelRegionVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodoMapper {
    List<SelRegionVo> selRegion();
    List<SelRegionDetailVo> selDetailRegion();
    int insTitle(InsTitleDto dto);
    int insSubTitle(String subTitle);
    int insCheckList(List<InsCheckListVo> list);
    String selIdRegion(int idRegion);
    String selIdRegionDetail(int idRegionDetail);

    int updTitle(UpdTitleDto dto);
    int updSubTitle(updSubTitleEntity entity);

    int delCheckList(DelCheckListDto dto);
    int delSubTitle(DelSubTitleDto dto);
    int updTravel(UpdTravelDto dto);
}
