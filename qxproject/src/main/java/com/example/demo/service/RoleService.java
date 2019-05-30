package com.example.demo.service;

import com.example.demo.Utils.TreeNoteUtil;
import com.example.demo.dao.MenuMapper;
import com.example.demo.dao.Tb_RoleMapper;
import com.example.demo.entity.Menu;
import com.example.demo.entity.Menutree;
import com.example.demo.entity.Tb_Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface RoleService {
    /**
     *@描述
     *@类名  RoleService
     *@参数
     *@返回值
     *@创建人  唐庆阳
     *@创建时间  2019-05-26
     *@修改人和其它信息
     */
    public List<Menutree> getrolemenus(Integer roleid);

    public Map<String,Object> getrolemenubyname(String rolename);

    /**
     *@描述
     *@类名  RoleService
     *@参数  [roleid]
     *@返回值  java.util.List<com.example.demo.entity.Menutree>
     *@创建人  唐庆阳
     *@创建时间  2019-05-26
     *@修改人和其它信息
     */
    public List<Menutree> getmenubyroleid(Integer roleid);
    /**
     *@描述 插入角色
     *@类名  RoleService
     *@参数  [tb_role]
     *@返回值  int
     *@创建人  唐庆阳
     *@创建时间  2019-05-26
     *@修改人和其它信息
     */
    public int insetrole(Tb_Role tb_role);

    /**
     *@描述 删除角色
     *@类名  RoleService
     *@参数  [roles]
     *@返回值  int
     *@创建人  唐庆阳
     *@创建时间  2019-05-26
     *@修改人和其它信息
     */
    public int deleteroles(String roles);

    /**
     *@描述 修改角色
     *@类名  RoleService
     *@参数  [tb_role]
     *@返回值  int
     *@创建人  唐庆阳
     *@创建时间  2019-05-26
     *@修改人和其它信息
     */
    public int editrole(@RequestBody Tb_Role tb_role);

    /**
     *@描述 获取所有角色信息
     *@类名  RoleService
     *@参数  []
     *@返回值  java.util.List<com.example.demo.entity.Tb_Role>
     *@创建人  唐庆阳
     *@创建时间  2019-05-26
     *@修改人和其它信息
     */
    public  List<Tb_Role> findall();


    public List<Tb_Role> getallroles(Integer roleid,String rolename);
}
