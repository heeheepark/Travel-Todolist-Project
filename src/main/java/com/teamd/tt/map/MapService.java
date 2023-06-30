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

    public List<SelInfoVo> selAllInfo() {
        return mapper.selAllInfo();
    }

    public List<SelInfoVo> selPickInfo(SelPickInfoDto dto) {
        return mapper.selPickInfo(dto);
    }

    public List<SelInfoVo> selPickDetailInfo(SelPickDetailInfoDto dto) {
        return mapper.selPickDetailInfo(dto);
    }


}
