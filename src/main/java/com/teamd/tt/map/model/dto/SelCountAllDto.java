package com.teamd.tt.map.model.dto;

import com.teamd.tt.map.model.vo.SelCountDetailMapVo;
import com.teamd.tt.map.model.vo.SelCountMapVo;
import lombok.Data;

import java.util.List;

@Data
public class SelCountAllDto {
    private int totalCount;
    private List<SelCountMapVo> region;
    private List<SelCountDetailMapVo> regionDetail;
}