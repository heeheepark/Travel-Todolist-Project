package com.teamd.tt.todolist.model;

import lombok.Data;

@Data
public class updSubTitleEntity {
    private int idSub;
    private int idTitle;
    private String subTitle;
    private String createdAt;
    private String updatedAt;
    private boolean finishYn;

}
