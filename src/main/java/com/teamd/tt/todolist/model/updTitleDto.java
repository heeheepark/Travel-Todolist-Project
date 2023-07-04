package com.teamd.tt.todolist.model;

import lombok.Data;

@Data
public class updTitleDto {
    private int idRegion;
    private int idRegionDetail;
    private String startDate;
    private String endDate;
    private String calColor;
}
