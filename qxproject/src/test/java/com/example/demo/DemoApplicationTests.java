package com.example.demo;

import com.example.demo.Utils.TreeNoteUtil;
import com.example.demo.dao.MenuMapper;
import com.example.demo.dao.Tb_RoleMapper;
import com.example.demo.dao.UserDataMapper;
import com.example.demo.entity.Menu;
import com.example.demo.entity.Menutree;
import com.example.demo.entity.Tb_Role;
import com.example.demo.entity.UserData;
import com.example.demo.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
public class DemoApplicationTests {
    private TreeNoteUtil treeNoteUtil = new TreeNoteUtil();
    @Autowired
    private UserDataMapper userDataMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private Tb_RoleMapper tb_roleMapper;

    @Autowired
    private RoleService roleService;

    @Test
    public void contextLoads() {
//        UserData userData=new UserData();
//        userData.setUsername("emiya");
//        userData.setPassword("123654");
        Tb_Role tb_role=new Tb_Role();
//        tb_role.setRoleName("超");
        tb_role.setRoleid(1);
        System.out.println(roleService.getmenubyroleid(1));
    }



}
