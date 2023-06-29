package com.teamd.tt.todolist.model;

import lombok.Data;

@Data
public class SelMapTravelDto {
    private String region;
    private String regionDetail;
    private String subTitle;
    private int subTitlefinishYn;
    private String checkList;
    private int checkListfinishYn;
    private String startDate;
}
