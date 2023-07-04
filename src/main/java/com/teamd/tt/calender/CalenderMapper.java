package com.teamd.tt.calender;

import com.teamd.tt.calender.model.*;
import com.teamd.tt.map.model.*;
import com.teamd.tt.map.model.SelAllCheckVo;
import com.teamd.tt.map.model.SelAllSubVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CalenderMapper {
    List<SelAllCalVo> selAllCalSchedule (String date);
    SelInfoDto selTitle(SelTitleDto dto);
    List<SelAllSubVo> selSub(SelSubDto dto);
    List<SelAllCheckVo> selCheck(SelCheckDto dto);
}
