package com.teamd.tt.todolist.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class UpdSubTitleListVo {
    private String subTitle;
    private List<InsCheckListVo> checkList;
}
