package com.chuanandhe.firstblog.myblog.utils;

public class Pageutil {
    public static int page;   //页码
    public static final int pageNum=3; //每一页显示三条

    public static int getPage() {
        return page;
    }

    public static void setPage(int page) {
        Pageutil.page = page;
    }

    public static int countShowBlog(String page){
        page="1";
        return (Integer.parseInt(page)-1)*pageNum;
    }
}
