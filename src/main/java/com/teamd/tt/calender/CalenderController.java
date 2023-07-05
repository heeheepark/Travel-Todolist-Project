package com.teamd.tt.calender;

import com.teamd.tt.calender.model.*;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{idTitle}")
    @Operation(summary = "달력에서 선택한 선택한 여행",
            description = "<h3>idTitle : 여행리스트 키값\n")
    public SelInfoDto getTitle(@PathVariable int idTitle) {
        SelTitleDto dto = new SelTitleDto();
        dto.setIdTitle(idTitle);
        return service.selTitle(dto);
    }

    @GetMapping("/{idTitle}/sub")
    @Operation(summary = "달력에서 선택한 여행의 Todo",
            description = "<h3>idTitle : 여행리스트 키값\n")
    public List<SelAllCalSubVo> getSub(@PathVariable int idTitle) {
        SelSubDto dto = new SelSubDto();
        dto.setIdTitle(idTitle);
        return service.selSub(dto);
    }

    @GetMapping("/{idSub}/check")
    @Operation(summary = "달력에서 선택한 여행의 Todo의 checklist",
            description = "<h3>idSub : Todo의 키값\n")
    public List<SelAllCalCheckVo> getCheck(@PathVariable int idSub) {
        SelCheckDto dto = new SelCheckDto();
        dto.setIdSub(idSub);
        return service.selCheck(dto);
    }
}
