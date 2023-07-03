package com.teamd.tt.map;

import com.teamd.tt.map.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MapMapper {
    List<SelInfoVo> selAllTitle();
    List<SelAllSubVo> selSub(SelAllSubDto dto);
    List<SelAllCheckVo> selCheck(SelAllCheckDto dto);
    List<SelInfoVo> selRegionTitle(SelRegionTitleDto dto);
    List<SelInfoVo> selRegionDetailTitle(SelRegionDetailTitleDto dto);
}