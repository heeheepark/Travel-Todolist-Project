package com.teamd.tt.map;

import com.teamd.tt.map.model.SelMapTravelVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MapMapper {
    List<SelMapTravelVo> selAllinfo();
}
