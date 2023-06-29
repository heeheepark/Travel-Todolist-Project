package com.teamd.tt.todolist;

import com.teamd.tt.todolist.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TodoMapper mapper;

    @Autowired
    public TodoService(TodoMapper mapper) {
        this.mapper = mapper;
    }

    public SelRegionVoAll selRegion() {
        List<SelRegionVo> dto = mapper.selRegion();
        List<SelRegionDetailVo> dto1 = mapper.selDetailRegion();

        return SelRegionVoAll.builder()
                .region(dto)
                .regionDetail(dto1)
                .build();
    }
}
