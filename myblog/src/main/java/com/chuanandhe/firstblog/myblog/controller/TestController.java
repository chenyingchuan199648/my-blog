package com.chuanandhe.firstblog.myblog.controller;

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

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
       // AdminUser adminUser=testDao.findUser();
        User user=new User();
        user.setName("xi");
        user.setAge("23");
        user.setSex("man");
        testDao.insertUser(user);
        return  "OK";
    }
}
