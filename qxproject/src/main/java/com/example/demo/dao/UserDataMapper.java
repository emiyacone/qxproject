package com.example.demo.dao;

import com.example.demo.entity.Tb_Role;
import com.example.demo.entity.UserData;

import java.util.List;

public interface UserDataMapper {

    UserData findrolebyuserid(Integer userid);

    UserData findrolebyunameandpaw(UserData userData);

    List<UserData> selectusername(String username);

    List<UserData> findallusers();

    List<UserData> selectbyusername(String username);

    int deleteByPrimaryKey(Integer userid);

    int insert(UserData record);

    int insertSelective(UserData record);

    UserData selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(UserData record);

    int updateByPrimaryKey(UserData record);

    UserData selectbyunameandpaw(UserData userData);
}