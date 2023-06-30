package com.teamd.tt.calender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalenderService {
    private final CalenderMapper mapper;

    @Autowired
    public CalenderService(CalenderMapper mapper) {
        this.mapper = mapper;
    }

}
