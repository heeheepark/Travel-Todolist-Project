package com.teamd.tt;

import com.teamd.tt.model.SelRegion;
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

    public List<String> selRegion(SelRegion idregion) {
        if(idregion.getIdRegion()) {
            return mapper.selRegion();
        } else if (idregion.getIdRegion() > 0) {
            return mapper.selDetailRegion(idregion.getIdRegion());
        }
        return null;
    }

    public List<String> selDetailRegion(int idRegion) {
        return mapper.selDetailRegion(idRegion);
    }
}
