package com.example.demo.dao;

import com.example.demo.entity.Tiediscuss;

import java.util.List;

public interface TiediscussMapper {
    List<Tiediscuss> findalltiediscuss();

    List<Tiediscuss> selectBytieid(Integer tieid);

    int deleteByPrimaryKey(Integer discussId);

    int insert(Tiediscuss record);

    int insertSelective(Tiediscuss record);

    Tiediscuss selectByPrimaryKey(Integer discussId);

    int updateByPrimaryKeySelective(Tiediscuss record);

    int updateByPrimaryKey(Tiediscuss record);
}