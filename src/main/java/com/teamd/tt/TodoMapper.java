package com.teamd.tt;

import com.teamd.tt.model.SelRegionDetailVo;
import com.teamd.tt.model.SelRegionVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodoMapper {
    List<SelRegionVo> selRegion();
    List<SelRegionDetailVo> selDetailRegion();

}
