package com.example.demo.service;

import com.example.demo.entity.User_rela_roleKey;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserRoleService {
    public int binduserrole(User_rela_roleKey rela_roleKey);
}
