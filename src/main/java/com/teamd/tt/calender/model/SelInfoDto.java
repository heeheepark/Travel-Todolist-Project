package com.teamd.tt.calender.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
public class SelInfoDto {
    private int idTitle;
    private String title;
    private String startDate;
    private String endDate;
}
