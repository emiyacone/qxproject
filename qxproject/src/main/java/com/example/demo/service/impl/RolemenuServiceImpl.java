package com.example.demo.service.impl;

import com.example.demo.dao.Role_rela_menuMapper;
import com.example.demo.dao.Tb_RoleMapper;
import com.example.demo.entity.Menu;
import com.example.demo.entity.Menutree;
import com.example.demo.entity.Role_rela_menuKey;
import com.example.demo.entity.Tb_Role;
import com.example.demo.service.RoleService;
import com.example.demo.service.RolemenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: qxproject
 * @description:
 * @author: 唐庆阳
 * @create: 2019-05-29 16:44
 **/
@Service
public class RolemenuServiceImpl implements RolemenuService {
    @Autowired
    private Role_rela_menuMapper role_rela_menu;

    @Autowired
    private RoleService roleService;

    @Autowired
    private Tb_RoleMapper tb_roleMapper;

    @Override
    public String updaterolemenu(String menuids, String rolename) {
        String ids[]=menuids.split(",");
        List<Menu> menus=new ArrayList<>();
        Tb_Role tb_role=new Tb_Role();
        Role_rela_menuKey role_rela_menukey=new Role_rela_menuKey();
        tb_role=tb_roleMapper.findmenubyrolename(rolename).get(0);
        role_rela_menukey.setRoleid(tb_role.getRoleid());
        menus=tb_role.getMenus();
        for(int i=0;i<menus.size();i++){
            role_rela_menukey.setMenuid(menus.get(i).getMenuid());
            role_rela_menu.deleteByPrimaryKey(role_rela_menukey);
        }
        for(int i=0;i<ids.length;i++)
        {

            role_rela_menukey.setMenuid(Integer.parseInt(ids[i]));
            role_rela_menu.insert(role_rela_menukey);
        }
//        for(int i=0;i<ids.length;i++)
//        {
////            count=userDataMapper.deleteByPrimaryKey(Integer.parseInt(ids[i]));
//        }
        return "true";

    }

    @Override
    public List<Menutree> getmenubyroleid(Integer roleid) {
        return roleService.getmenubyroleid(roleid);
    }
}
