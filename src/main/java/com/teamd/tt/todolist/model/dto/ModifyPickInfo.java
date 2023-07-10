package com.teamd.tt.todolist.model.dto;

import com.teamd.tt.todolist.model.vo.ModifyPickSubListVo;
import lombok.Data;

import java.util.List;

@Data
public class ModifyPickInfo {
    private int idTitle;
    private int idRegionDetail;
    private int idRegion;
    private String startDate;
    private String endDate;
    private String calColor;
    private String travelReview;
    private List<ModifyPickSubListVo> subList;
}
