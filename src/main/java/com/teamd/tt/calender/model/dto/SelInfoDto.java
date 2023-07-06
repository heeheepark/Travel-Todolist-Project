package com.teamd.tt.calender.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
public class SelInfoDto {
    private int idTitle;
    private String title;
    private String startDate;
    private String endDate;
    private String travelReview;
}
