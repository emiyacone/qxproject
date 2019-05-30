package com.example.demo.controller;

import com.example.demo.entity.Role_rela_menuKey;
import com.example.demo.service.RoleService;
import com.example.demo.dao.Tb_RoleMapper;
import com.example.demo.dao.Role_rela_menuMapper;
import com.example.demo.entity.Menu;
import com.example.demo.entity.Menutree;
import com.example.demo.entity.Tb_Role;
import com.example.demo.service.RolemenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rolemenu")
@EnableAutoConfiguration
public class RoleMenuController {
    @Autowired
    private RolemenuService rolemenuService;

    @RequestMapping("/insertrolemenu")
    public String updaterolemenu(@RequestParam("menuids") String menuids,@RequestParam("rolename") String rolename){
       return rolemenuService.updaterolemenu(menuids,rolename);
    }

    @RequestMapping("/getmenubyroleid")
    public List<Menutree> getmenubyroleid(@RequestParam("roleid") Integer roleid)
    {
        return rolemenuService.getmenubyroleid(roleid);
    }

}
