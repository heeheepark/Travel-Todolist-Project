package com.teamd.tt.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class SelRegionVoAll {
    private List<SelRegionVo> region;
    private List<SelRegionDetailVo> regionDetail;
}
