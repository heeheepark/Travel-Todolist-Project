package com.teamd.tt.calender;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calender")
public class CalenderController {
    private final CalenderService service;

    @Autowired
    public CalenderController(CalenderService service) {
        this.service = service;
    }

//    @GetMapping
//    @Operation(summary = "캘린더 일정 데이터") //쿼리스트링


}
