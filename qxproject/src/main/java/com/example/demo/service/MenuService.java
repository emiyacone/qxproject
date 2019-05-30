package com.example.demo.service;

import com.example.demo.Utils.TreeNoteUtil;
import com.example.demo.dao.MenuMapper;
import com.example.demo.entity.Menu;
import com.example.demo.entity.Menutree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *@描述
 *@类名  MenuService
 *@参数
 *@返回值
 *@创建人  唐庆阳
 *@创建时间  2019-05-26
 *@修改人和其它信息
 */
public interface MenuService {

    /**
     *@描述对数据库中获取的菜单进行处理用于easyui显示
     *@类名  MenuService
     *@参数  []
     *@返回值  java.util.List<com.example.demo.entity.Menutree>
     *@创建人  唐庆阳
     *@创建时间  2019-05-26
     *@修改人和其它信息
     */
    public List<Menutree> getmenutree();


    /**
     *@描述 //批量删除菜单
     *@类名  MenuService
     *@参数  [menus]
     *@返回值  int
     *@创建人  唐庆阳
     *@创建时间  2019-05-26
     *@修改人和其它信息
     */
    public int deletemenus(String menus);

    /**
     *@描述//对菜单信息进行更新
     *@类名  MenuService
     *@参数  [menu]
     *@返回值  int
     *@创建人  唐庆阳
     *@创建时间  2019-05-26
     *@修改人和其它信息
     */
    public int editmenu(Menu menu);

    /**
     *@描述   //插入菜单
     *@类名  MenuService
     *@参数  [menu]
     *@返回值  int
     *@创建人  唐庆阳
     *@创建时间  2019-05-26
     *@修改人和其它信息
     */
    public int insetmenu(Menu menu);

    /**
     *@描述//获取所有菜单信息
     *@类名  MenuService
     *@参数  []
     *@返回值  java.util.List<com.example.demo.entity.Menu>
     *@创建人  唐庆阳
     *@创建时间  2019-05-26
     *@修改人和其它信息
     */
    public List<Menu> getallmenus();

}
