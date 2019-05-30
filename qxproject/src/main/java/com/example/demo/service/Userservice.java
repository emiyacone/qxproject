package com.example.demo.service;


import com.example.demo.dao.UserDataMapper;
import com.example.demo.entity.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @描述
 * @类名 Userservice
 * @参数
 * @返回值
 * @创建人 唐庆阳
 * @创建时间 2019-05-26
 * @修改人和其它信息
 */
public interface Userservice {

    /**
     *@描述 获取所有用户信息
     *@类名 Userservice
     *@参数 [id, username]
     *@返回值 java.util.List<com.example.demo.entity.UserData>
     *@创建人 唐庆阳
     *@创建时间 2019-05-26
     *@修改人和其它信息
     */
    public List<UserData> getAllusers(Integer id, String username);
    /**
     *@描述 插入一个用户
     *@类名 Userservice
     *@参数 [userData]
     *@返回值 int
     *@创建人 唐庆阳
     *@创建时间 2019-05-26
     *@修改人和其它信息
     */
    public int insertuser(UserData userData);
    /**
     *@描述 删除用户
     *@类名 Userservice
     *@参数 [users]
     *@返回值 int
     *@创建人 唐庆阳
     *@创建时间 2019-05-26
     *@修改人和其它信息
     */
    public int deleteusers(String users);
    /**
     *@描述 修改用户
     *@类名 Userservice
     *@参数 [userData]
     *@返回值 int
     *@创建人 唐庆阳
     *@创建时间 2019-05-26
     *@修改人和其它信息
     */
    public int edituser(UserData userData);
    /**
     *@描述 模糊查询用户名
     *@类名 Userservice
     *@参数 [username]
     *@返回值 java.util.List<com.example.demo.entity.UserData>
     *@创建人 唐庆阳
     *@创建时间 2019-05-26
     *@修改人和其它信息
     */
    public List<UserData> findlikeusername(String username);
    /**
     *@描述 通过id精确获取用户
     *@类名 Userservice
     *@参数 [id]
     *@返回值 java.util.List<com.example.demo.entity.UserData>
     *@创建人 唐庆阳
     *@创建时间 2019-05-26
     *@修改人和其它信息
     */
    public List<UserData> getuserbyid(Integer id);
    /**
     *@描述 实现登录功能
     *@类名 Userservice
     *@参数 [username, password]
     *@返回值 com.example.demo.entity.UserData
     *@创建人 唐庆阳
     *@创建时间 2019-05-26
     *@修改人和其它信息
     */
    public UserData login(String username, String password);

}
