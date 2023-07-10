package com.teamd.tt.todolist.model.dto;

import lombok.Data;

@Data
public class InsCheckListDto {
    private int idSub;
    private String checkTitle;
    private boolean finishYn;
}
