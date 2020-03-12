package com.chuanandhe.firstblog.myblog.controller;

import com.chuanandhe.firstblog.myblog.dao.AdminUserDao;
import com.chuanandhe.firstblog.myblog.dao.TestDao;
import com.chuanandhe.firstblog.myblog.entity.AdminUser;
import com.chuanandhe.firstblog.myblog.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @Autowired
    private TestDao testDao;
    @Autowired
    private AdminUserDao adminUserDao;

    @RequestMapping("/test")
    @ResponseBody
    public AdminUser test(){
        AdminUser adminUser=adminUserDao.findAdminUser("admin");
        return  adminUser;
    }
}
