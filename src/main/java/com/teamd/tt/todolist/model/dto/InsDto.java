package com.teamd.tt.todolist.model.dto;

import com.teamd.tt.todolist.model.vo.InsSubTitleListVo;
import lombok.Data;

import java.util.List;

@Data
public class InsDto {
    private int idRegionDetail;
    private int idRegion;
    private String startDate;
    private String endDate;
    private String calColor;
    List<InsSubTitleListVo> subList;
}
