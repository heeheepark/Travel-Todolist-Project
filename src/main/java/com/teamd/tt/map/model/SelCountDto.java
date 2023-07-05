package com.teamd.tt.map.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
public class SelCountDto {
    private int totalCount;
    private List<SelCountMapVo> region;
}
