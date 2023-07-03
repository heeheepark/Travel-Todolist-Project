package com.teamd.tt.map;

import com.teamd.tt.map.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapService {
    private final MapMapper mapper;

    @Autowired
    public MapService(MapMapper mapper) {
        this.mapper = mapper;
    }

    public List<SelInfoVo> selAllTitle() {
        return mapper.selAllTitle();
    }

    public List<SelAllSubVo> selSub(SelAllSubDto dto) {
        return mapper.selSub(dto);
    }

    public List<SelAllCheckVo> selCheck(SelAllCheckDto dto) {
        return mapper.selCheck(dto);
    }

    public List<SelInfoVo> selRegionTitle(SelRegionTitleDto dto) {
        return mapper.selRegionTitle(dto);
    }

    public List<SelInfoVo> selRegionDetailTitle(SelRegionDetailTitleDto dto) {
        return mapper.selRegionDetailTitle(dto);
    }
}
