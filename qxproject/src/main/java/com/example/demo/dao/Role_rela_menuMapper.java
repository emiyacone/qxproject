package com.example.demo.dao;

import com.example.demo.entity.Role_rela_menuKey;

public interface Role_rela_menuMapper {
    int deleteByPrimaryKey(Role_rela_menuKey key);

    int insert(Role_rela_menuKey record);

    int insertSelective(Role_rela_menuKey record);

}