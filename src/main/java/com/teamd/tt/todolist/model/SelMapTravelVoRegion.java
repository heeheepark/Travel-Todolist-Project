package com.teamd.tt.todolist.model;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder

public class SelMapTravelVoRegion {
    private String travelRegion;
    private String subTitle;
    private int subTitlefinishYn;
    private String checkList;
    private int checkListfinishYn;
    private String startDate;
}
