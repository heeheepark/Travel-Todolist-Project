package com.teamd.tt.calender;

import com.teamd.tt.calender.model.SelAllCalVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CalenderMapper {
    List<SelAllCalVo> selAllCalSchedule (String date);

}
