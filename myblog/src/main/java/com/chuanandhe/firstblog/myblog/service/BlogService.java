package com.chuanandhe.firstblog.myblog.service;

import com.chuanandhe.firstblog.myblog.entity.Blog;
import com.chuanandhe.firstblog.myblog.entity.Result;

import java.util.List;

public interface BlogService {
    Result<List> getBlogs(String page);
}
