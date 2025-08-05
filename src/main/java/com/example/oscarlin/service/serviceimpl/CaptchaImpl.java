package com.example.oscarlin.service.serviceimpl;

import com.example.oscarlin.service.CaptchaService;
import com.example.oscarlin.utils.VerifyCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Slf4j
@Service
public class CaptchaImpl implements CaptchaService {
    @Override
    public void getAuthCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("image/jpeg");
        response.setDateHeader("expires",-1);
        response.setHeader("Cache-Control","no-cache");
        response.setHeader("Pragma","no-cache");
        String verifyCode= VerifyCodeUtils.generateVerifyCode(4);
        request.getSession().setAttribute("verifyCode",verifyCode);
        VerifyCodeUtils.outputImage(60,30,response.getOutputStream(),verifyCode);
        log.info("验证码为"+verifyCode);
    }

    @Override
    public Boolean verifyCode(String inputVerify, HttpServletRequest request) {
        String verifyCode=(String)request.getSession().getAttribute("verifyCode");
        return inputVerify.equalsIgnoreCase(verifyCode);
    }
}
