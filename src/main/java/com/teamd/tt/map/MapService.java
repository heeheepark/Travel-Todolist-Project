package com.teamd.tt.map;

import com.teamd.tt.map.model.SelMapTravelVo;
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

    public List<SelMapTravelVo> selAllinfo() {
        return mapper.selAllinfo();
    }
}
