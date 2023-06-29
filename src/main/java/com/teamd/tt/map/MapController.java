package com.teamd.tt.map;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/map")
public class MapController {
    private final MapService service;

    @Autowired
    public MapController(MapService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "지도 전체 여행")
    public List<?> getMapTravelList () {
        return service.selAllinfo();
    }
}
