package com.teamd.tt.todolist.model;

import lombok.Data;

import java.util.List;

@Data
public class InsDto {
    InsTitleDto titleDto;
    List<InsSubTitleDto> subList;
    List<InsCheckListDto> checkList;
}
