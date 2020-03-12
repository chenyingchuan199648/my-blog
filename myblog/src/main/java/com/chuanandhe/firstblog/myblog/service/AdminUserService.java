package com.chuanandhe.firstblog.myblog.service;


import com.chuanandhe.firstblog.myblog.entity.Result;

public interface AdminUserService {
    Result login(String  name,String password,String verifyCode);
}
