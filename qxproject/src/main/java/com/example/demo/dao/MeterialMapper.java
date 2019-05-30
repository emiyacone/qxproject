package com.example.demo.dao;

import com.example.demo.entity.Meterial;

import java.util.List;

public interface MeterialMapper {
    int deleteByPrimaryKey(Integer meterialid);

    int insert(Meterial record);

    int insertSelective(Meterial record);

    Meterial selectByPrimaryKey(Integer meterialid);

    int updateByPrimaryKeySelective(Meterial record);

    int updateByPrimaryKey(Meterial record);

    List<Meterial> findallmenus();
}