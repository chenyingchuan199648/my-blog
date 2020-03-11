package com.chuanandhe.firstblog.myblog.dao;

import com.chuanandhe.firstblog.myblog.entity.AdminUser;
import com.chuanandhe.firstblog.myblog.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface TestDao {
    AdminUser findUser();
    void insertUser(User user);
}
