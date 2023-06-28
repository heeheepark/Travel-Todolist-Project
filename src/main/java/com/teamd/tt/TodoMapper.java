package com.teamd.tt;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodoMapper {
    List<String> selRegion();
    List<String> selDetailRegion(int idRegion);

}
