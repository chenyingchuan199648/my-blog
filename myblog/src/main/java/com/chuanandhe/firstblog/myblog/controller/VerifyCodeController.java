package com.chuanandhe.firstblog.myblog.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
* 生成验证码的请求
* */

@Controller
public class VerifyCodeController {
    private DefaultKaptcha defaultKaptcha;

    @RequestMapping("/verifyCode")
    public void generateVerifyCode(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException{
        byte[] captchaOutputStream = null;
        ByteArrayOutputStream imgOutputStream=new ByteArrayOutputStream();
        try {
            String verifyCode=defaultKaptcha.createText();
            httpServletRequest.getSession().setAttribute("verifyCode",verifyCode);
            BufferedImage image= defaultKaptcha.createImage(verifyCode);
            ImageIO.write(image,"jpg",imgOutputStream);
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
        captchaOutputStream=imgOutputStream.toByteArray();
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream = httpServletResponse.getOutputStream();
        responseOutputStream.write(captchaOutputStream);
        responseOutputStream.flush();
        responseOutputStream.close();
    }
}
