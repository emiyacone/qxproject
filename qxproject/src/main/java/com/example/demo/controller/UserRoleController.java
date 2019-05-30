package com.example.demo.controller;


import com.example.demo.entity.User_rela_roleKey;
import com.example.demo.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userrole")
@EnableAutoConfiguration
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    @RequestMapping("/insert")
    public int binduserrole(@RequestBody User_rela_roleKey rela_roleKey){
        return userRoleService.binduserrole(rela_roleKey);
    }

}
