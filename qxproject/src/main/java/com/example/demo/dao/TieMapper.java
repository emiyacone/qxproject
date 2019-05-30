package com.example.demo.dao;

import com.example.demo.entity.Tie;

import java.util.List;

public interface TieMapper {
    List<Tie> findallties();

    int deleteByPrimaryKey(Integer tieid);

    int insert(Tie record);

    int insertSelective(Tie record);

    Tie selectByPrimaryKey(Integer tieid);

    int updateByPrimaryKeySelective(Tie record);

    int updateByPrimaryKey(Tie record);
}