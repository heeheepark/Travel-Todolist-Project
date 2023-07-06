package com.teamd.tt.calender;

import com.teamd.tt.calender.model.dto.*;
import com.teamd.tt.calender.model.vo.SelAllCalCheckVo;
import com.teamd.tt.calender.model.vo.SelAllCalSubVo;
import com.teamd.tt.calender.model.vo.SelAllCalVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalenderService {
    private final CalenderMapper mapper;

    @Autowired
    public CalenderService(CalenderMapper mapper) {
        this.mapper = mapper;
    }

    public List<SelAllCalVo> selAllCalSchedule (SelAllCalScheduleDto dto) {
        String date = String.valueOf(dto.getYear()) + "-" + String.valueOf(dto.getMonth()) + "-" + "1";
        return mapper.selAllCalSchedule(date);
    }

    public SelInfoDto selTitle(SelTitleDto dto) {
        return mapper.selTitle(dto);
    }
    public List<SelAllCalSubVo> selSub(SelSubDto dto){
        return mapper.selSub(dto);
    }
    public List<SelAllCalCheckVo> selCheck(SelCheckDto dto){
        return mapper.selCheck(dto);
    }
}
