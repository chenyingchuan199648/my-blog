package com.chuanandhe.firstblog.myblog.service.imp;

import com.chuanandhe.firstblog.myblog.dao.BlogDao;
import com.chuanandhe.firstblog.myblog.entity.Blog;
import com.chuanandhe.firstblog.myblog.entity.Result;
import com.chuanandhe.firstblog.myblog.service.BlogService;
import com.chuanandhe.firstblog.myblog.utils.Pageutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImp implements BlogService {
    @Autowired
    private BlogDao blogDao;

    @Override
    public Result<List> getBlogs(String page) {
        int start=Pageutil.countShowBlog(page);
        List<Blog> blogList =blogDao.findBlog(start,Pageutil.pageNum);
        Result<List> result=new Result<>();
        result.setResultData(blogList);
        result.setResulteMessage("查询博客");
        result.setResultState("0");
        return result;
    }
}
