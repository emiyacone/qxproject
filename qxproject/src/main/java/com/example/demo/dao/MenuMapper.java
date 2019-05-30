package com.example.demo.dao;

import com.example.demo.entity.Menu;

import java.util.List;

public interface MenuMapper {
    List<Menu> selectallmenus();

    int deleteByparentmenu(String parentmenu);

    int deleteByPrimaryKey(Integer menuid);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer menuid);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
}