package com.teamd.tt.todolist.model.vo;

import lombok.Data;

import java.util.List;
@Data
public class ModifyPickSubListVo {
    private int idSub;
    private String subTitle;
    private boolean finishYn;
    private List<ModifyPickCheckListVo> checkList;
}
