package com.teamd.tt.todolist.model;

import lombok.Data;

import java.util.Date;

@Data
public class InsTitleDto {
    private int idRegion;
    private int idRegionDetail;
    private String startDate;
    private String endDate;
    private String calColor;
}
