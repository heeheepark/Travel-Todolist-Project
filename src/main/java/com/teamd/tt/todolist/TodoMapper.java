package com.teamd.tt.todolist;

import com.teamd.tt.todolist.model.SelMapTravelVo;
import com.teamd.tt.todolist.model.SelRegionDetailVo;
import com.teamd.tt.todolist.model.SelRegionVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodoMapper {
    List<SelRegionVo> selRegion();
    List<SelRegionDetailVo> selDetailRegion();
    List<SelMapTravelVo> selAllinfo();

}
