package com.teamd.tt.todolist.model.dto;

import com.teamd.tt.todolist.model.vo.InsSubTitleListVo;
import com.teamd.tt.todolist.model.vo.SelSubTitleListVo;
import lombok.Data;

import java.util.List;

@Data
public class SelPickInfo {
    private int idTitle;
    private String region;
    private String regionDetail;
    private String startDate;
    private String endDate;
    private String calColor;
    private String travelReview;
    private List<SelSubTitleListVo> subList;
}
