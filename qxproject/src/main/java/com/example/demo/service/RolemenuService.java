package com.example.demo.service;

import com.example.demo.entity.Menutree;

import java.util.List;

public interface RolemenuService {
    public String updaterolemenu( String menuids,  String rolename);
    public List<Menutree> getmenubyroleid( Integer roleid);
}
