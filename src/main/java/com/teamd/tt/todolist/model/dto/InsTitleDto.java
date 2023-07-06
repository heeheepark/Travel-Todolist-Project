package com.teamd.tt.todolist.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class InsTitleDto {
    private int idRegionDetail;
    private int idRegion;
    private String title;
    private String startDate;
    private String endDate;
    private String calColor;
}
