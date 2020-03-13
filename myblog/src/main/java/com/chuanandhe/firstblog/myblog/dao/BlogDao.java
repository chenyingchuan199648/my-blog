package com.chuanandhe.firstblog.myblog.dao;


import com.chuanandhe.firstblog.myblog.entity.Blog;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogDao {

     List<Blog> findBlog(int start,int pagenum);
}
