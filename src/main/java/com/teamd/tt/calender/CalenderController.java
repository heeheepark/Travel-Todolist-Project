package com.teamd.tt.calender;

import com.teamd.tt.calender.model.SelAllCalScheduleDto;
import com.teamd.tt.calender.model.SelAllCalVo;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/calender")
public class CalenderController {
    private final CalenderService service;

    @Autowired
    public CalenderController(CalenderService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "캘린더 전체 일정 데이터",
    description = "<h3>year : 년도 입력(시작날짜 연도로 구분중)\n" +
    "<h3>month : 달 입력(시작날짜 달로 구분중)\n")
    public List<SelAllCalVo> getAllSchedule (@RequestParam int year, @RequestParam int month) {
        SelAllCalScheduleDto dto = new SelAllCalScheduleDto();
        dto.setYear(year);
        dto.setMonth(month);
        return service.selAllCalSchedule(dto);
    }

//    @GetMapping
//    @Operation(summary = "캘린더 일정 데이터") //쿼리스트링


}
