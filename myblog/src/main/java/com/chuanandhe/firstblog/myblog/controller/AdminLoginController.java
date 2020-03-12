package com.chuanandhe.firstblog.myblog.controller;

import com.chuanandhe.firstblog.myblog.entity.Result;
import com.chuanandhe.firstblog.myblog.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminLoginController {

    @Autowired
    private AdminUserService adminUserService;
    @RequestMapping("/login")
    public String login(@RequestParam String name,
                        @RequestParam String password,
                        @RequestParam String verifyCode,
                        HttpSession session){
        Result result=null;
        if (name!=null||password!=null||verifyCode!=null){
            String verifyKey=(String) session.getAttribute("verifyCode");
            if (!verifyCode.equals(verifyKey)){
                session.setAttribute("error","验证码错误");
            }else {
                result=adminUserService.login(name,password,verifyCode);
                if (result.getResultState()=="0"){  //登陆成功
                    return "redirect:/idnex";
                }
                session.setAttribute("error","用户名或密码错误");
            }
        }
        return result.getResulteMessage();
    }
}
