package com.teamd.tt.map;

import com.teamd.tt.map.model.dto.*;
import com.teamd.tt.map.model.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public SelCountAllDto selCountMapAll () {
        List<Integer> idList = mapper.getRegionIdList();
        List<SelCountMapVo> list = mapper.selCountMap(idList);

        List<Integer> idList2 = mapper.getRegionDetailIdList();
        List<SelCountDetailMapVo> list2 = mapper.selCountDetailMap(idList2);

        int countAll = mapper.getCountAll();
        SelCountAllDto dto = new SelCountAllDto();
        dto.setTotalCount(countAll);
        dto.setRegion(list);
        dto.setRegionDetail(list2);

        return dto;
    }
}
