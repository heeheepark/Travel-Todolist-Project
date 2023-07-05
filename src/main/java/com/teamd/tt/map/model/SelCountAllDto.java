package com.teamd.tt.map.model;

import lombok.Data;

import java.util.List;

@Data
public class SelCountAllDto {
    private int totalCount;
    private List<SelCountMapVo> region;
    private List<SelCountDetailMapVo> regionDetail;
}
