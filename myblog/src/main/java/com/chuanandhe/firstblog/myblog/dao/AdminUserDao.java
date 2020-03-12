package com.chuanandhe.firstblog.myblog.dao;

import com.chuanandhe.firstblog.myblog.entity.AdminUser;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminUserDao {
    AdminUser findAdminUser(String name);
}
