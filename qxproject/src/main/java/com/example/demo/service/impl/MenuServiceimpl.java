package com.example.demo.service.impl;

import com.example.demo.Utils.TreeNoteUtil;
import com.example.demo.dao.MenuMapper;
import com.example.demo.entity.Menu;
import com.example.demo.entity.Menutree;
import com.example.demo.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service
public class MenuServiceimpl implements MenuService {
    private TreeNoteUtil treeNoteUtil=new TreeNoteUtil();
    @Autowired
    private MenuMapper menuMapper;

    /**
     *@描述对数据库中获取的菜单进行处理用于easyui显示
     *@类名  MenuService
     *@参数  []
     *@返回值  java.util.List<com.example.demo.entity.Menutree>
     *@创建人  唐庆阳
     *@创建时间  2019-05-26
     *@修改人和其它信息
     */
    public List<Menutree> getmenutree()
    {

        Map<String, Object> attributes = new HashMap<String, Object>();
        List<Menu> menuList=new ArrayList<>();
        List<Menutree> menutreeList=new ArrayList<>();
        Menutree menutree=new Menutree();
        menuList=menuMapper.selectallmenus();
        for(int i=0;i<menuList.size();i++){
            menutree= treeNoteUtil.menuformat(menuList.get(i),attributes,false);
            menutreeList.add(menutree);
        }
        menutreeList=treeNoteUtil.getFatherNode(menutreeList);
        return menutreeList;
    }


    /**
     *@描述 //批量删除菜单
     *@类名  MenuService
     *@参数  [menus]
     *@返回值  int
     *@创建人  唐庆阳
     *@创建时间  2019-05-26
     *@修改人和其它信息
     */
    public int deletemenus(String menus)
    {
        int count=0;
        String menuids="";
        List<Menu> list= menuMapper.selectallmenus();
        for(int j=0;j<list.size();j++)
        {
            if(list.get(j).getMenuLevel().equals("1"))
            {
                menuids=menuids+list.get(j).getMenuid()+",";
            }
        }
        String menu[]=menuids.split(",");
        String ids[]=menus.split(",");
        for(int i=0;i<ids.length;i++)
        {
            for(int k=0;k<menu.length;k++)
            {
                if(ids[i].equals(menu[k])) {
                    count = count + menuMapper.deleteByPrimaryKey(Integer.parseInt(ids[i]));
                    count=count+menuMapper.deleteByparentmenu(menu[k]);
                }
            }
            count = count + menuMapper.deleteByPrimaryKey(Integer.parseInt(ids[i]));

        }
        return count==0?0:1;
    }

    /**
     *@描述//对菜单信息进行更新
     *@类名  MenuService
     *@参数  [menu]
     *@返回值  int
     *@创建人  唐庆阳
     *@创建时间  2019-05-26
     *@修改人和其它信息
     */
    public int editmenu(Menu menu){

        int count=menuMapper.updateByPrimaryKey(menu);
        return count==0?0:1;
    }

    /**
     *@描述   //插入菜单
     *@类名  MenuService
     *@参数  [menu]
     *@返回值  int
     *@创建人  唐庆阳
     *@创建时间  2019-05-26
     *@修改人和其它信息
     */
    public int insetmenu(Menu menu){
        return menuMapper.insert(menu);
    }

    /**
     *@描述//获取所有菜单信息
     *@类名  MenuService
     *@参数  []
     *@返回值  java.util.List<com.example.demo.entity.Menu>
     *@创建人  唐庆阳
     *@创建时间  2019-05-26
     *@修改人和其它信息
     */
    public List<Menu> getallmenus(){

        return menuMapper.selectallmenus();
    }

}
