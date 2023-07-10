package com.teamd.tt.todolist.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
public class InsSubTitleListVo {
    private String subTitle;
    private List<InsCheckListVo> checkList;
}
