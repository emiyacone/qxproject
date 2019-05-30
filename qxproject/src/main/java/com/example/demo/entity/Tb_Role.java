package com.example.demo.entity;

import java.util.List;

public class Tb_Role {
    private Integer roleid;

    private String roleName;

    private String roleMessage;

    private List<Menu> menus;

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleMessage() {
        return roleMessage;
    }

    public void setRoleMessage(String roleMessage) {
        this.roleMessage = roleMessage == null ? null : roleMessage.trim();
    }

    @Override
    public String toString() {
        return "Tb_Role{" +
                "roleid=" + roleid +
                ", roleName='" + roleName + '\'' +
                ", roleMessage='" + roleMessage + '\'' +
                ", menus=" + menus +
                '}';
    }


}