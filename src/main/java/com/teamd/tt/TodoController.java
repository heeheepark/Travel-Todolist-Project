package com.teamd.tt;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tt")
public class TodoController {
    private final TodoService service;

    @Autowired
    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping("/todo")
    @Operation(summary = "지역 목록")
    public List<String> getRegion() {
        return service.selRegion();
    }

    @GetMapping("/todo")
    @Operation(summary = "세부 지역 목록")
    public List<String> selDetailRegion(@RequestParam int idRegion) {
        return service.selDetailRegion(idRegion);
    }
}
