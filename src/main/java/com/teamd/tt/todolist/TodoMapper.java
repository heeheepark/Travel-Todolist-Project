package com.teamd.tt.todolist;

import com.teamd.tt.todolist.model.dto.*;
import com.teamd.tt.todolist.model.vo.*;
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

    SelPickInfo selPickTravelInfo(int idTitle);
    List<SelSubTitleListVo> selPickTravelInfoDetail(int idTitle);

//    int updTitle(UpdTitleDto dto);
//    int updSubTitle(updSubTitleEntity entity);

    int delCheckList(DelCheckListDto dto);
    int delSubTitle(DelSubTitleDto dto);
    int updTravel(UpdTravelDto dto);
}
