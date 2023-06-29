package com.teamd.tt.todolist.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SelMapTravelVo {
    private String region;
    private String regionDetail;
    private String subTitle;
    private int subTitlefinishYn;
    private String checkList;
    private int checkListfinishYn;
    private String startDate;


}
