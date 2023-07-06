package com.teamd.tt.todolist.model.dto;

import lombok.Data;

@Data
public class SelPickInfoDto {
    private int idTitle;
    private String region;
    private String regionDetail;
    private String startDate;
    private String endDate;
    private String calColor;
}
