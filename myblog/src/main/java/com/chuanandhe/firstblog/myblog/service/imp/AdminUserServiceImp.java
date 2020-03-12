package com.chuanandhe.firstblog.myblog.service.imp;

import com.chuanandhe.firstblog.myblog.dao.AdminUserDao;
import com.chuanandhe.firstblog.myblog.entity.AdminUser;
import com.chuanandhe.firstblog.myblog.entity.Result;
import com.chuanandhe.firstblog.myblog.service.AdminUserService;
import com.chuanandhe.firstblog.myblog.utils.MD5util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminUserServiceImp implements AdminUserService {
    @Autowired
    private AdminUserDao adminUserDao;
    @Autowired
    private Result result;

    @Override
    public Result login(String name,String password,String verifyCode) {
        AdminUser adminUser =adminUserDao.findAdminUser(name);
        if (adminUser==null){
            result.setResultState("1");
            result.setResulteMessage("用户名不存在！");
        }else {
            if (MD5util.MD5Encode(password,"utf-8").equals(adminUser.getLogin_password())){
                result.setResultState("0");
                result.setResulteMessage("登陆成功！");
            }else {
                result.setResultState("0");
                result.setResulteMessage("密码不正确！");
            }
        }
        return result;
    }
}
