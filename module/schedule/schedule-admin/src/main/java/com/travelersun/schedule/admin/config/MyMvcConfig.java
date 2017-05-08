package com.travelersun.schedule.admin.config;

import com.travelersun.schedule.admin.controller.resolver.WebExceptionResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;

/**
 * Created by Raya on 2017/3/26.
 */
@Configuration
public class MyMvcConfig {

    @Bean("exceptionResolver")
    public HandlerExceptionResolver exceptionResolver(){
        return new WebExceptionResolver();
    }

}
