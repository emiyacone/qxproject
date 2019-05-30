package com.example.demo.dao;

import com.example.demo.entity.User_rela_roleKey;

public interface User_rela_roleMapper {
    int deleteByPrimaryKey(User_rela_roleKey key);

    int insert(User_rela_roleKey record);

    int insertSelective(User_rela_roleKey record);
}