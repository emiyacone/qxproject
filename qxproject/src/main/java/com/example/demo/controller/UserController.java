package com.example.demo.controller;

import com.example.demo.entity.UserData;
import com.example.demo.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@EnableAutoConfiguration
public class UserController {

    @Autowired
    private Userservice userservice;

    @RequestMapping("/getAlluser")
    public List<UserData> getAllcompany(@RequestParam("userid") Integer id,@RequestParam("username") String username) {
      return userservice.getAllusers(id,username);
    }

    @RequestMapping("/hello")
    public String hello(){
        return "Helloworld";
    }

    @PostMapping("/insertuser")
    public int insertuser(@RequestBody UserData userData)
    {
       return userservice.insertuser(userData);
    }

    @PostMapping("/deleteusers")
    public int deleteusers(@RequestParam("users") String users)
    {
        return userservice.deleteusers(users);
    }

    @PostMapping("/edituser")
    public int edituser(@RequestBody UserData userData)
    {
       return userservice.edituser(userData);
    }

    @GetMapping("/getbyusername")
    public List<UserData> findlikeusername(@RequestParam("username") String username)
    {
        return userservice.findlikeusername(username);
    }

    @GetMapping("/getbyid")
    public List<UserData> getuserbyid(@RequestParam("id") Integer id){

        return userservice.getuserbyid(id);
    }

    @RequestMapping("/login")
    public UserData login(@RequestParam("username") String username,@RequestParam("password") String password){
        return userservice.login(username,password);
    }
}
