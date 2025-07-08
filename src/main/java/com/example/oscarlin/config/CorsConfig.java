package com.example.oscarlin.config;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 允许所有路径
                .allowedOriginPatterns("http://localhost:5173", "https://example.com") // 允许的来源
                .allowedMethods("GET", "POST", "PUT", "DELETE") // 允许的HTTP方法
                .allowedHeaders("*") // 允许的请求头
                .allowCredentials(true) // 是否允许携带Cookie
                .maxAge(3600); // 预检请求缓存时间（秒）
    }
}

