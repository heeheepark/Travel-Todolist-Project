package com.teamd.tt.todolist;

import com.teamd.tt.todolist.model.*;
import io.swagger.v3.oas.annotations.Operation;
import org.springdoc.core.utils.SpringDocUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todo")
public class TodoController {
    private final TodoService service;

    @Autowired
    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Todolist 지역 목록")
    public SelRegionVoAll getRegion() {
        return service.selRegion();
    }

    @PostMapping("")
    @Operation(summary = "여행Title 추가")
    public int postAddTitle(@RequestBody InsTitleDto dto) {
        return service.insAddTitle(dto);
    }

    @PostMapping("/sub")
    @Operation(summary = "여행subTitle 추가")
    public int postAddSubTitle(@RequestBody InsSubTitleDto dto) {
        return service.insAddSubTitle(dto);
    }

    @PostMapping("/sub/checklist")
    @Operation(summary = "checkList 추가")
    public int postAddcheckList(@RequestBody IntCheckListDto dto) {
        return service.insAddCheckList(dto);
    }
}