package com.example.redission.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebConfig
 *
 * @author: admin
 * @create: 2022/03/18 22:54
 */
@Configuration
@Slf4j
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        log.info("registry before: {}", registry);
//        registry.addResourceHandler("/((?!console).)*/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/gui/**").addResourceLocations("classpath:/static/console/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/gui/#/login/").setViewName("forward:/console/index.html");
        registry.addViewController("/").setViewName("forward:/console/index.html");
        registry.addRedirectViewController("/", "forward:/console/index.html");
    }
}
