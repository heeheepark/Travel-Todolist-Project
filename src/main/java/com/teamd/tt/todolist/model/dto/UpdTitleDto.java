package com.teamd.tt.todolist.model.dto;

import lombok.Data;

@Data
public class UpdTitleDto {
    private int idRegion;
    private int idRegionDetail;
    private String startDate;
    private String endDate;
    private String calColor;
}