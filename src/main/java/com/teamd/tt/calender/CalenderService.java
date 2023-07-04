package com.teamd.tt.calender;

import com.teamd.tt.calender.model.SelAllCalScheduleDto;
import com.teamd.tt.calender.model.SelAllCalVo;
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

}
