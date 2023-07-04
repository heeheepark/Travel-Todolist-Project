package com.teamd.tt.calender;

import com.teamd.tt.calender.model.*;
import com.teamd.tt.calender.model.SelAllCalCheckVo;
import com.teamd.tt.calender.model.SelAllCalSubVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CalenderMapper {
    List<SelAllCalVo> selAllCalSchedule(String date);
    SelInfoDto selTitle(SelTitleDto dto);
    List<SelAllCalSubVo> selSub(SelSubDto dto);
    List<SelAllCalCheckVo> selCheck(SelCheckDto dto);
}
