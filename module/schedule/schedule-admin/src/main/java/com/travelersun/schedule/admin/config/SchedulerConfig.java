package com.travelersun.schedule.admin.config;

import com.travelersun.schedule.admin.core.schedule.XxlJobDynamicScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;


/**
 * Created by Raya on 2017/3/26.
 */
@Configuration
public class SchedulerConfig {

    @Value("${xxl.job.callBackIp}")
    String callBackIp;

    @Value("${xxl.job.callBackPort}")
    int callBackPort;

    @Value("${classpath:quartz.properties}")
    Resource quartzConfig;

    @Autowired
    DataSource dataSource;


    @Bean("quartzScheduler")
    public SchedulerFactoryBean quartzScheduler(){
        SchedulerFactoryBean  scheduler = new SchedulerFactoryBean();

        scheduler.setDataSource(dataSource);
        scheduler.setAutoStartup(true);

        scheduler.setStartupDelay(20);

        scheduler.setApplicationContextSchedulerContextKey("applicationContextKey");

        scheduler.setConfigLocation(quartzConfig);

        return scheduler;
    }

    @Bean(value = "xxlJobDynamicScheduler",initMethod = "init",destroyMethod = "destroy")
    public XxlJobDynamicScheduler xxlJobDynamicScheduler(){
        XxlJobDynamicScheduler xxlJobDynamicScheduler = new XxlJobDynamicScheduler();
        xxlJobDynamicScheduler.setScheduler(quartzScheduler().getScheduler());
        xxlJobDynamicScheduler.setCallBackIp(callBackIp);
        xxlJobDynamicScheduler.setCallBackPort(callBackPort);
        return xxlJobDynamicScheduler;

    }

    @PostConstruct
    void test(){
        System.out.println("start");

    }

}
