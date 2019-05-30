package com.example.demo.service.impl;

import com.example.demo.dao.User_rela_roleMapper;
import com.example.demo.entity.User_rela_roleKey;
import com.example.demo.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: qxproject
 * @description:
 * @author: 唐庆阳
 * @create: 2019-05-29 16:49
 **/
@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private User_rela_roleMapper userRelaRoleMapper;
    @Override
    public int binduserrole(User_rela_roleKey rela_roleKey) {
        return userRelaRoleMapper.insert(rela_roleKey);
    }
}
