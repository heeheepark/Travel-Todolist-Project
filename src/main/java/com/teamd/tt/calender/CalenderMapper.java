package com.teamd.tt.calender;

import com.teamd.tt.calender.model.vo.SelAllCalCheckVo;
import com.teamd.tt.calender.model.vo.SelAllCalSubVo;
import com.teamd.tt.calender.model.dto.SelCheckDto;
import com.teamd.tt.calender.model.dto.SelInfoDto;
import com.teamd.tt.calender.model.dto.SelSubDto;
import com.teamd.tt.calender.model.dto.SelTitleDto;
import com.teamd.tt.calender.model.vo.SelAllCalVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CalenderMapper {
    List<SelAllCalVo> selAllCalSchedule(String date);
    SelInfoDto selTitle(SelTitleDto dto);
    List<SelAllCalSubVo> selSub(SelSubDto dto);
    List<SelAllCalCheckVo> selCheck(SelCheckDto dto);
}
