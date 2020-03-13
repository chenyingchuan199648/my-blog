package com.chuanandhe.firstblog.myblog.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager")
public class AdminManagerController {

    @RequestMapping("/operate")
    public String toManager(){
        return "index";
    }
}
