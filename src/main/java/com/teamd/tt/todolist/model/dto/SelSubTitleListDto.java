package com.teamd.tt.todolist.model.dto;

import com.teamd.tt.todolist.model.vo.SelCheckListVo;
import lombok.Data;

import java.util.List;

@Data
public class SelSubTitleListDto {
    private int idSub;
    private String subTitle;
    private boolean finishYn;
    private List<SelCheckListVo> checkList;
}
