package com.example.demo.controller;


import com.example.demo.entity.Menu;
import com.example.demo.entity.Menutree;
import com.example.demo.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
@EnableAutoConfiguration
public class MenuController {
    /**
     *@描述 
     *@类名  MenuController
     *@参数  
     *@返回值  
     *@创建人  唐庆阳
     *@创建时间  2019-05-26
     *@修改人和其它信息
     */
    @Autowired
    private MenuService menuService;

    @RequestMapping("/getallformmenus")
    public List<Menutree> getallformmenus(){
        return menuService.getmenutree();
    }

    @RequestMapping("/getallmenus")
    public List<Menu> getallmenus(){
        return menuService.getallmenus();
    }

    @PostMapping("/insertmenu")
    public int insertmenu(@RequestBody Menu menu)
    {
        return menuService.insetmenu(menu);
    }

    @PostMapping("/deletemenus")
    public int deletemenus(@RequestParam("menus") String menus)
    {
        return menuService.deletemenus(menus);
    }

    @PostMapping("/editmenu")
    public int editmenu(@RequestBody Menu menu)
    {
        return menuService.editmenu(menu);
    }
}
