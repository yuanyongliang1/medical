package com.system.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.awt.*;

/**
 * @ClassName: MyWebAppConfigurer
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/8/3 20:16
 */
@Slf4j
@Configuration
public class MyWebAppConfigurer implements WebMvcConfigurer {

    @Value("${winResource}")
private String windowsFilepathPre;



    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        windowsFilepathPre = windowsFilepathPre.replace('\\', '/');
        log.info("路径为: "+ windowsFilepathPre + "/");
        registry.addResourceHandler("/**")
                .addResourceLocations("file:" + windowsFilepathPre + "/")
                .addResourceLocations("classpath:/static/");
    }
}






































