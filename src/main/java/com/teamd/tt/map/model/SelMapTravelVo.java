package com.teamd.tt.map.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SelMapTravelVo {
    private String travelRegion;
    private String subTitle;
    private int subTitlefinishYn;
    private String checkList;
    private int checkListfinishYn;
    private String startDate;
}
