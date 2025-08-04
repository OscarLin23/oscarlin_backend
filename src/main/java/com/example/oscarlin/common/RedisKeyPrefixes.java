package com.example.oscarlin.common;

public interface RedisKeyPrefixes {

    /**
     * 所有key前面加上服务名
     */
    String PREFIX_BASE = "login-captcha:";

    /**
     * 用户登录的验证码
     */
    String PREFIX_CAPTCHA = PREFIX_BASE + "login_captcha:";
}
