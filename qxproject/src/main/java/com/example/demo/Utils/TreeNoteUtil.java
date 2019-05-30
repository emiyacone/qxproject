package com.example.demo.Utils;

import com.example.demo.entity.Menu;
import com.example.demo.entity.Menutree;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TreeNoteUtil {
    public  List<Menutree> getFatherNode(List<Menutree> treesList){
        List<Menutree> newTrees = new ArrayList<Menutree>();
        for (Menutree mt : treesList) {
            if (mt.getpId()==null||mt.getpId().equals("")) {//如果pId为空，则该节点为父节点
                //递归获取父节点下的子节点
                mt.setChildren(getChildrenNode(mt.getId(), treesList));
                newTrees.add(mt);
            }
        }
        return newTrees;
    }

    /**
     * 递归获取子节点下的子节点
     * @param pId 父节点的ID
     * @param treesList 所有菜单树集合
     * @return
     */
    private  List<Menutree> getChildrenNode(Integer pId, List<Menutree> treesList){
        List<Menutree> newTrees = new ArrayList<Menutree>();
        for (Menutree mt : treesList) {
            if (mt.getpId()==null||mt.getpId().equals("")) continue;
            if(Integer.parseInt(mt.getpId())==pId){
                //递归获取子节点下的子节点，即设置树控件中的children
                mt.setChildren(getChildrenNode(mt.getId(), treesList));
                //设置树控件attributes属性的数据
                newTrees.add(mt);
            }
        }
        return newTrees;
    }

    public Menutree menuformat(Menu menu, Map attributes,Boolean checked)
    {
        Menutree menutree=new Menutree();
        menutree.setId(menu.getMenuid());
        menutree.setpId(menu.getParentmenu());
        menutree.setText(menu.getMenuName());
        menutree.setAttributes(attributes);
        menutree.setUrl(menu.getMenuUrl());
        menutree.setChecked(checked);
        menutree.setIconCls(matchicon(menu.getMenuName()));
        return menutree;
    }

    public String matchicon(String text)
    {
        switch(text){
            case "系统管理":return "icon-application-cascade";
            case "用户管理":return "icon-users";
            case "角色管理":return "icon-user-group";
            case "权限配置":return "icon-book";
            case "菜单管理":return "icon-cog";
            case "内容管理":return "icon-application-form-edit";
            case "资料库":return "icon-chart-organisation";
            case "贴吧":return "icon-users";
            default:return "tree-file";
        }
    }
}
