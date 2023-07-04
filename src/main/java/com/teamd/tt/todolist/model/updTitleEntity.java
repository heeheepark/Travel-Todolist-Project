package com.teamd.tt.todolist.model;

import lombok.Data;

@Data
public class updTitleEntity {
    private int idRegion;
    private int idRegionDetail;
    private String startDate;
    private String endDate;
    private String calColor;
    private int idTitle;
    private String title;
}
