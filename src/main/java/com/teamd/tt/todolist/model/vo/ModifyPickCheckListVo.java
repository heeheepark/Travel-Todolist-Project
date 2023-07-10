package com.teamd.tt.todolist.model.vo;

import lombok.Data;

@Data
public class ModifyPickCheckListVo {
    private int idCheck;
    private String checkTitle;
    private boolean finishYn;
}
