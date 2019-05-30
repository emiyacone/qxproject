package com.example.demo.dao;

import com.example.demo.entity.Menu;
import com.example.demo.entity.Tb_Role;

import java.util.List;

public interface Tb_RoleMapper {

    List<Tb_Role> selectallroles();

    List<Tb_Role> findall();

    Tb_Role findmenubyroleid(Integer roleid);

    List<Tb_Role> findmenubyrolename(String role_name);

    int deleteByPrimaryKey(Integer roleid);

    int insert(Tb_Role record);

    int insertSelective(Tb_Role record);

    Tb_Role selectByPrimaryKey(Integer roleid);

    int updateByPrimaryKeySelective(Tb_Role record);

    int updateByPrimaryKey(Tb_Role record);
}