package com.chuanandhe.firstblog.myblog.controller;

import com.chuanandhe.firstblog.myblog.entity.Result;
import com.chuanandhe.firstblog.myblog.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/admin")
public class AdminLoginController {

    @Autowired
    private AdminUserService adminUserService;
    private Result result=null;

    @PostMapping("/login")
    @ResponseBody
    public Result login( String username,
                         String password,
                         String verifyCode,
                        HttpSession session
                        ){
        if (username!=null||password!=null||verifyCode!=null){
            String verifyKey=(String) session.getAttribute("verifyCode");
            if (!verifyCode.equals(verifyKey)){
                result.setResultState("1");
                result.setResulteMessage("验证码错误");
            }else {
                result=adminUserService.login(username,password,verifyCode);
            }
        }
        return result;
    }

    @GetMapping("/tologin")
    public String toLogin(Model model){
        return "login";
    }
}
