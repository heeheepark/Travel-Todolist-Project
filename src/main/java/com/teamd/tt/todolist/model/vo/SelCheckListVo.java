package com.teamd.tt.todolist.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
public class SelCheckListVo {
    private int idCheck;
    private String checkTitle;
    private boolean finishYn;
}
