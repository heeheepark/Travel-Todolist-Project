package com.teamd.tt.todolist.model.dto;

import lombok.Data;

@Data
public class UpdCheckListDto {
    private int idCheck;
    private String checkTitle;
    private boolean finishYn;
}
