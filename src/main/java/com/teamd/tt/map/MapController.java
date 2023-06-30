package com.teamd.tt.map;

import com.teamd.tt.map.model.SelPickDetailInfoDto;
import com.teamd.tt.map.model.SelPickInfoDto;
import com.teamd.tt.map.model.SelInfoVo;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
            description = "<h3>idTitle : 여행리스트 키값" +
                    "<h3>title : 시,도 + 시,군,구 이름\n")
    public List<SelInfoVo> getMapTravelList() {
        return service.selAllInfo();
    }

    @GetMapping("/{idRegion}")
    @Operation(summary = "지도 지역(시,도) 선택 여행리스트",
            description = "<h3>idRegion : 지역 아이디\n" +
                    "<h3>idTitle : 여행리스트 키값" +
                    "<h3>title : 시,도 + 시,군,구 이름\n")
    public List<SelInfoVo> getMapPickList(@PathVariable int idRegion) {
        SelPickInfoDto dto = new SelPickInfoDto();
        dto.setIdRegion(idRegion);
        return service.selPickInfo(dto);
    }

    @GetMapping("/{idRegion}/{idRegionDetail}")
    @Operation(summary = "지도 지역(시,군,구) 선택 여행리스트",
            description = "<h3>idRegion : 지역 아이디\n" +
                    "<h3>idRegionDetail : 세부 지역 아이디" +
                    "<h3>idTitle : 여행리스트 키값" +
                    "<h3>title : 시,도 + 시,군,구 이름\n")
    public List<SelInfoVo> selPickDetailInfo(@PathVariable int idRegion, @PathVariable int idRegionDetail) {
        SelPickDetailInfoDto dto = new SelPickDetailInfoDto();
        dto.setIdRegion(idRegion);
        dto.setIdRegionDetail(idRegionDetail);
        return service.selPickDetailInfo(dto);
    }

//    @GetMapping("/{idRegion}/{idRegionDetail}")
//    @Operation(summary = "지도 세부지역(시,군,구) 선택 여행리스트")
}
