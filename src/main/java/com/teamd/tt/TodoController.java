package com.teamd.tt;

import com.teamd.tt.model.SelRegionVoAll;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
    private final TodoService service;

    @Autowired
    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping("/todo")
    @Operation(summary = "지역 목록")
    public SelRegionVoAll getRegion() {
        return service.selRegion();
    }
}