package com.teamd.tt.map;

import com.teamd.tt.map.model.SelPickDetailInfoDto;
import com.teamd.tt.map.model.SelPickInfoDto;
import com.teamd.tt.map.model.SelInfoVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MapMapper {
    List<SelInfoVo> selAllInfo();
    List<SelInfoVo> selPickInfo(SelPickInfoDto dto);
    List<SelInfoVo> selPickDetailInfo(SelPickDetailInfoDto dto);
}