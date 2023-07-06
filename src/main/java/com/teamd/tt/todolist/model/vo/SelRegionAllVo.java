package com.teamd.tt.todolist.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class SelRegionAllVo {
    private List<SelRegionVo> region;
    private List<SelRegionDetailVo> regionDetail;
}
