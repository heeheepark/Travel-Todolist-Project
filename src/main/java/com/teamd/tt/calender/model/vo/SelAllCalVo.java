package com.teamd.tt.calender.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SelAllCalVo {
    private int idTitle;
    private String title;
    private String startDate;
    private String endDate;
    private String calColor;
}