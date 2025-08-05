package com.example.oscarlin.controller;

import com.example.oscarlin.common.Result;
import com.example.oscarlin.service.CaptchaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@RestController
public class CaptchaController {
    @Autowired
    private CaptchaService captchaService;
    /**
     * 生成图片验证码
     * time用于保证每次可以刷新图片验证码
     */
    @GetMapping("authCode/{time}")
    public void getAuthCode(@PathVariable("time")String time, HttpServletRequest request, HttpServletResponse response) throws IOException {
        captchaService.getAuthCode(request,response);
    }

    /**
     * 验证图片验证码
     */
    @GetMapping("verifyCode/{inputVerify}")
    public Result verifyCode(@PathVariable("inputVerify") String inputVerify, HttpServletRequest request){
        Boolean bool = captchaService.verifyCode(inputVerify,request);
         return new Result("200",bool,"已验证");
    }
}
