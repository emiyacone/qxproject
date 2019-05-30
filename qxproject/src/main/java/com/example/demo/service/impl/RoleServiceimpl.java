package com.example.demo.service.impl;

import com.example.demo.Utils.TreeNoteUtil;
import com.example.demo.dao.MenuMapper;
import com.example.demo.dao.Tb_RoleMapper;
import com.example.demo.entity.Menu;
import com.example.demo.entity.Menutree;
import com.example.demo.entity.Tb_Role;
import com.example.demo.entity.UserData;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleServiceimpl implements RoleService {
    /**
     *@描述
     *@类名  RoleService
     *@参数
     *@返回值
     *@创建人  唐庆阳
     *@创建时间  2019-05-26
     *@修改人和其它信息
     */
    private TreeNoteUtil treeNoteUtil=new TreeNoteUtil();
    @Autowired
    private Tb_RoleMapper tb_roleMapper;

    @Autowired
    private MenuMapper menuMapper;

    public List<Menutree> getrolemenus(Integer roleid){
        /**
         *@描述 根据roleid获取菜单
         *@类名  RoleService
         *@参数  [roleid]
         *@返回值  java.util.List<com.example.demo.entity.Menutree>
         *@创建人  唐庆阳
         *@创建时间  2019-05-26
         *@修改人和其它信息
         */
        Map<String, Object> attributes = new HashMap<String, Object>();
        List<Menu> list1=new ArrayList<>();
        List<Menu> list2=new ArrayList<>();
        Tb_Role tb_role=new Tb_Role();
        tb_role=tb_roleMapper.findmenubyroleid(roleid);
//        System.out.print(tb_role);
        list2=tb_role.getMenus();
        List<Menutree> menutreeList=new ArrayList<>();
        list1=menuMapper.selectallmenus();
//        System.out.print(list2);
        Menutree menutree=new Menutree();
        for(int i=0;i<list1.size();i++)
        {
            if(list1.get(i).getMenuLevel().equals("1"))
            {
                menutree=treeNoteUtil.menuformat(list1.get(i),attributes,false);
            }
            else {
                if(list2.size()>0)
                {
                    for(int j=0;j<list2.size();j++)
                    {
                        if(list2.get(j).getMenuid()==list1.get(i).getMenuid())
                        {
                            attributes.put("checked",true);
                            menutree=treeNoteUtil.menuformat(list1.get(i),attributes,true);
                            break;
                        }
                        else {
                            menutree=treeNoteUtil.menuformat(list1.get(i),attributes,false);
                        }
                    }
                }
                else{
                    menutree=treeNoteUtil.menuformat(list1.get(i),null,false);
                }
            }
            menutreeList.add(menutree);
        }
        menutreeList=treeNoteUtil.getFatherNode(menutreeList);
        return menutreeList;
    }

    public Map<String,Object> getrolemenubyname(String rolename){
        /**
         *@描述 根据角色名rolename获取角色的菜单
         *@类名  RoleService
         *@参数  [rolename]
         *@返回值  java.util.Map<java.lang.String,java.lang.Object>
         *@创建人  唐庆阳
         *@创建时间  2019-05-26
         *@修改人和其它信息
         */
        Map<String,Object> roledatas=new HashMap<String,Object>();
        Map<String, Object> attributes = new HashMap<String, Object>();
        List<Menu> list1=new ArrayList<>();
        List<Menu> list2=new ArrayList<>();
        Tb_Role tb_role=new Tb_Role();
        tb_role=tb_roleMapper.findmenubyrolename(rolename).get(0);
//        System.out.print(tb_role);
        list2=tb_role.getMenus();
        List<Menutree> menutreeList=new ArrayList<>();
        list1=menuMapper.selectallmenus();
//        System.out.print(list2);
        Menutree menutree=new Menutree();
        for(int i=0;i<list1.size();i++)
        {
            if(list1.get(i).getMenuLevel().equals("1"))
            {
                menutree=treeNoteUtil.menuformat(list1.get(i),attributes,false);
            }
            else {
                if(list2.size()>0)
                {
                    for(int j=0;j<list2.size();j++)
                    {
                        if(list2.get(j).getMenuid()==list1.get(i).getMenuid())
                        {
                            attributes.put("checked",true);
                            menutree=treeNoteUtil.menuformat(list1.get(i),attributes,true);
                            break;
                        }
                        else {
                            menutree=treeNoteUtil.menuformat(list1.get(i),attributes,false);
                        }
                    }
                }
                else{
                    menutree=treeNoteUtil.menuformat(list1.get(i),null,false);
                }
            }
            menutreeList.add(menutree);
        }
        menutreeList=treeNoteUtil.getFatherNode(menutreeList);
        roledatas.put("rolename",tb_role.getRoleName());
        roledatas.put("menutrees",menutreeList);
        return roledatas;
    }

    public List<Menutree> getmenubyroleid(Integer roleid){
        /**
         *@描述
         *@类名  RoleService
         *@参数  [roleid]
         *@返回值  java.util.List<com.example.demo.entity.Menutree>
         *@创建人  唐庆阳
         *@创建时间  2019-05-26
         *@修改人和其它信息
         */
        Map<String, Object> attributes = new HashMap<String, Object>();
        List<Menu> list1=new ArrayList<>();
        List<Menutree> menutreeList=new ArrayList<>();
        Tb_Role tb_role=new Tb_Role();
        tb_role=tb_roleMapper.findmenubyroleid(roleid);
//        System.out.print(tb_role);
        list1=tb_role.getMenus();
        Menutree menutree=new Menutree();
        for(int i=0;i<list1.size();i++)
        {
            menutree=treeNoteUtil.menuformat(list1.get(i),attributes,true);
            menutreeList.add(menutree);
        }
        menutreeList=treeNoteUtil.getFatherNode(menutreeList);
        return menutreeList;
    }
    /**
     *@描述 获取所有角色的角色信息
     *@类名  RoleService
     *@参数  [roleid, rolename]
     *@返回值  java.util.List<com.example.demo.entity.Tb_Role>
     *@创建人  唐庆阳
     *@创建时间  2019-05-26
     *@修改人和其它信息
     */
    public List<Tb_Role> getallroles(Integer roleid,String rolename){
        List<Tb_Role> list=new ArrayList<>();
        System.out.print("rolename:"+rolename);
        if(roleid==null&&rolename==null)
        {
            list=tb_roleMapper.selectallroles();
            return list;
        }
        else if(roleid!=null)
        {
            Tb_Role tb_role=new Tb_Role();
            tb_role=tb_roleMapper.selectByPrimaryKey(roleid);
            list.add(tb_role);
            return list;
        }
        else if(rolename!=null)
        {
            Tb_Role tb_role=new Tb_Role();
            list=tb_roleMapper.findmenubyrolename(rolename);
            return list;
        }
        return list;
    }

    public int insetrole(Tb_Role tb_role)
    {

        /**
         *@描述 插入角色
         *@类名  RoleService
         *@参数  [tb_role]
         *@返回值  int
         *@创建人  唐庆阳
         *@创建时间  2019-05-26
         *@修改人和其它信息
         */
        return tb_roleMapper.insert(tb_role);
    }

    /**
     *@描述 删除角色
     *@类名  RoleService
     *@参数  [roles]
     *@返回值  int
     *@创建人  唐庆阳
     *@创建时间  2019-05-26
     *@修改人和其它信息
     */
    public int deleteroles(String roles)
    {
        int count=0;
        System.out.println(roles);
        String ids[]=roles.split(",");
        for(int i=0;i<ids.length;i++)
        {
            count=tb_roleMapper.deleteByPrimaryKey(Integer.parseInt(ids[i]));
        }
        return count==0?0:1;
    }

    public int editrole(@RequestBody Tb_Role tb_role)
    {
        /**
         *@描述 修改角色
         *@类名  RoleService
         *@参数  [tb_role]
         *@返回值  int
         *@创建人  唐庆阳
         *@创建时间  2019-05-26
         *@修改人和其它信息
         */
        int count=tb_roleMapper.updateByPrimaryKey(tb_role);
        return count==0?0:1;
    }

    public  List<Tb_Role> findall()
    {
        /**
         *@描述 获取所有角色信息
         *@类名  RoleService
         *@参数  []
         *@返回值  java.util.List<com.example.demo.entity.Tb_Role>
         *@创建人  唐庆阳
         *@创建时间  2019-05-26
         *@修改人和其它信息
         */
        return tb_roleMapper.selectallroles();
    }


}
