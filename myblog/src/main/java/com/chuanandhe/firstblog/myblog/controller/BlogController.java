package com.chuanandhe.firstblog.myblog.controller;


import com.chuanandhe.firstblog.myblog.dao.BlogDao;
import com.chuanandhe.firstblog.myblog.entity.Blog;
import com.chuanandhe.firstblog.myblog.entity.Result;
import com.chuanandhe.firstblog.myblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;


    @RequestMapping("/")
    @ResponseBody
    public Result<List> toIndex(String page){
       Result<List> result= blogService.getBlogs(page);
       return result;
    }
}
