package com.example.demo.service.impl;


import com.example.demo.dao.UserDataMapper;
import com.example.demo.entity.UserData;
import com.example.demo.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
/**
 * @描述
 * @类名 Userservice
 * @参数
 * @返回值
 * @创建人 唐庆阳
 * @创建时间 2019-05-26
 * @修改人和其它信息
 */
public class Userserviceimpl implements Userservice {

    @Autowired
    private UserDataMapper userDataMapper;
    /**
     *@描述 获取所有用户信息
     *@类名 Userservice
     *@参数 [id, username]
     *@返回值 java.util.List<com.example.demo.entity.UserData>
     *@创建人 唐庆阳
     *@创建时间 2019-05-26
     *@修改人和其它信息
     */
    public List<UserData> getAllusers(Integer id, String username) {

        List<UserData> list = new ArrayList<>();
        System.out.print("username:" + username);
        if (id == null && username == null) {
            list = userDataMapper.findallusers();
            return list;
        } else if (id != null) {
            UserData userData = new UserData();
            userData = userDataMapper.selectByPrimaryKey(id);
            list.add(userData);
            return list;
        } else if (username != null) {
            list = userDataMapper.selectbyusername(username);
        }
        return list;
    }
    /**
     *@描述 插入一个用户
     *@类名 Userservice
     *@参数 [userData]
     *@返回值 int
     *@创建人 唐庆阳
     *@创建时间 2019-05-26
     *@修改人和其它信息
     */
    public int insertuser(UserData userData) {

        if (userDataMapper.selectusername(userData.getUsername()).size() > 0) {
            return 0;
        } else {
            return userDataMapper.insert(userData);
        }
    }
    /**
     *@描述 删除用户
     *@类名 Userservice
     *@参数 [users]
     *@返回值 int
     *@创建人 唐庆阳
     *@创建时间 2019-05-26
     *@修改人和其它信息
     */
    public int deleteusers(String users) {

        int count = 0;
        System.out.println(users);
        String ids[] = users.split(",");
        for (int i = 0; i < ids.length; i++) {
            count = userDataMapper.deleteByPrimaryKey(Integer.parseInt(ids[i]));
        }
        return count == 0 ? 0 : 1;
    }
    /**
     *@描述 修改用户
     *@类名 Userservice
     *@参数 [userData]
     *@返回值 int
     *@创建人 唐庆阳
     *@创建时间 2019-05-26
     *@修改人和其它信息
     */
    public int edituser(UserData userData) {

        int count = userDataMapper.updateByPrimaryKey(userData);
        return count == 0 ? 0 : 1;
    }
    /**
     *@描述 模糊查询用户名
     *@类名 Userservice
     *@参数 [username]
     *@返回值 java.util.List<com.example.demo.entity.UserData>
     *@创建人 唐庆阳
     *@创建时间 2019-05-26
     *@修改人和其它信息
     */
    public List<UserData> findlikeusername(String username) {

        return userDataMapper.selectbyusername(username);
    }
    /**
     *@描述 通过id精确获取用户
     *@类名 Userservice
     *@参数 [id]
     *@返回值 java.util.List<com.example.demo.entity.UserData>
     *@创建人 唐庆阳
     *@创建时间 2019-05-26
     *@修改人和其它信息
     */
    public List<UserData> getuserbyid(Integer id) {

        List<UserData> userlist = new ArrayList<>();
        UserData userData = new UserData();
        userlist.add(userData);
        return userlist;
    }
    /**
     *@描述 实现登录功能
     *@类名 Userservice
     *@参数 [username, password]
     *@返回值 com.example.demo.entity.UserData
     *@创建人 唐庆阳
     *@创建时间 2019-05-26
     *@修改人和其它信息
     */
    public UserData login(String username, String password) {

        UserData userData = new UserData();
        userData.setUsername(username);
        userData.setPassword(password);
        StringBuffer x = new StringBuffer();
        return userDataMapper.findrolebyunameandpaw(userData);
    }

}
