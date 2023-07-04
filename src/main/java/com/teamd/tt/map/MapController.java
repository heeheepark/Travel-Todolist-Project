package com.teamd.tt.map;

import com.teamd.tt.map.model.*;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/map")
public class MapController {
    private final MapService service;

    @Autowired
    public MapController(MapService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "지도 전체 여행리스트",
            description = "<h3>idTitle : 여행리스트 키값\n" +
                    "<h3>title : 시,도 + 시,군,구 이름\n")
    public List<SelInfoVo> getMapTravelList() {
        return service.selAllTitle();
    }

    @GetMapping("/sub/{idTitle}")
    @Operation(summary = "지도 전체 일정리스트",
            description = "<h3>idTitle : 여행리스트 키값\n" +
                    "<h3>subTitle : 일정 내용\n" +
                    "<h3>finishYn : 끝냄 여부")
    public List<SelAllSubVo> getMapSubList(@PathVariable int idTitle) {
        SelAllSubDto dto = new SelAllSubDto();
        dto.setIdTitle(idTitle);
        return service.selSub(dto);
    }

    @GetMapping("/check/{idSub}")
    @Operation(summary = "지도 전체 체크리스트\n"+
            "<h3>checkList : 준비리스트 내용\n" +
            "<h3>finishYn : 끝냄 여부")
    public List<SelAllCheckVo> selAllCheck(@PathVariable int idSub) {
        SelAllCheckDto dto = new SelAllCheckDto();
        dto.setIdSub(idSub);
        return service.selCheck(dto);
    }

    @GetMapping("/{idRegion}")
    @Operation(summary = "지도 지역(시,도) 선택 여행리스트",
            description = "<h3>idRegion : 지역 아이디\n" +
                    "<h3>idTitle : 여행리스트 키값\n" +
                    "<h3>title : 시,도 + 시,군,구 이름")
    public List<SelInfoVo> getMapPickList(@PathVariable int idRegion) {
        SelRegionTitleDto dto = new SelRegionTitleDto();
        dto.setIdRegion(idRegion);
        return service.selRegionTitle(dto);
    }

    @GetMapping("/{idRegion}/{idRegionDetail}")
    @Operation(summary = "지도 지역(시,군,구) 선택 여행리스트",
            description = "<h3>idRegion : 지역 아이디\n" +
                    "<h3>idRegionDetail : 세부 지역 아이디\n" +
                    "<h3>idTitle : 여행리스트 키값\n" +
                    "<h3>title : 시,도 + 시,군,구 이름")
    public List<SelInfoVo> selPickDetailInfo(@PathVariable int idRegion, @PathVariable int idRegionDetail) {
        SelRegionDetailTitleDto dto = new SelRegionDetailTitleDto();
        dto.setIdRegion(idRegion);
        dto.setIdRegionDetail(idRegionDetail);
        return service.selRegionDetailTitle(dto);
    }
}
