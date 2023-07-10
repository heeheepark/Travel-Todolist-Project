package com.teamd.tt.todolist;

import com.teamd.tt.todolist.model.dto.*;
import com.teamd.tt.todolist.model.vo.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodoMapper {

    int insTitle(InsTitleDto dto);
    int insSubTitle(String subTitle);
    int insSubTitle2(InsSubTitleDto dto);
    int insCheckList(List<InsCheckListVo> list);
    int insCheckList2(InsCheckListDto dto);

    int updTitle(UpdDto2 dto);
    int updSubList(UpdSubTitleDto dto);
    int updCheckList(UpdCheckListDto dto);

    String selIdRegion(int idRegion);
    String selIdRegionDetail(int idRegionDetail);
    List<SelRegionVo> selRegion();
    List<SelRegionDetailVo> selDetailRegion();
    SelPickInfo selPickTravelInfo(asdsadDto dto);
    int selLastSubId();

    int delCheckList(DelCheckListDto dto);
    int delSubTitle(DelSubTitleDto dto);
    int updTravel(UpdTravelDto dto);
}
