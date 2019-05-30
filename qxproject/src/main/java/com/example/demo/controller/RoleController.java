package com.example.demo.controller;


import com.example.demo.dao.MenuMapper;
import com.example.demo.entity.Menutree;
import com.example.demo.entity.Tb_Role;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/role")
@EnableAutoConfiguration
public class RoleController {
    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuMapper menuMapper;

    @RequestMapping("/findall")
    public  List<Tb_Role> findall()
    {
        return roleService.findall();
    }

    @RequestMapping("/getallroles")
    public List<Tb_Role> getallroles(@RequestParam("roleid") Integer roleid,@RequestParam("rolename") String rolename){
       return roleService.getallroles(roleid,rolename);
    }

    @PostMapping("/insertrole")
    public int insetrole(@RequestBody Tb_Role tb_role)
    {
        return roleService.insetrole(tb_role);
    }

    @PostMapping("/deleteroles")
    public int deleteroles(@RequestParam("roles") String roles)
    {
        return roleService.deleteroles(roles);
    }

    @PostMapping("/editrole")
    public int editrole(@RequestBody Tb_Role tb_role)
    {
       return roleService.editrole(tb_role);
    }

    @PostMapping("/getrolemenu")
    public List<Menutree> getrolemenu(@RequestParam("roleid") Integer roleid)
    {
        return roleService.getrolemenus(roleid);
    }


    @PostMapping("/getrolemenubyname")
    public Map<String,Object> getrolemenubyname(@RequestParam("rolename") String  rolename){

        return roleService.getrolemenubyname(rolename);
    }

}
