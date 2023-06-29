package com.teamd.tt.todolist;

import com.teamd.tt.todolist.model.SelRegionVoAll;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TodoController {
    private final TodoService service;

    @Autowired
    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping("/todo")
    @Operation(summary = "Todolist 지역 목록")
    public SelRegionVoAll getRegion() {
        return service.selRegion();
    }

}