package com.travelersun.schedule.exe.jobhandler.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.travelersun.schedule.core.executor.XxlJobExecutor;
import com.travelersun.schedule.core.glue.GlueFactory;
import com.travelersun.schedule.core.glue.loader.impl.DbGlueLoader;
import com.travelersun.schedule.core.registry.RegistHelper;
import com.travelersun.schedule.core.registry.impl.DbRegistHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Created by Raya on 2017/3/26.
 */
@Configuration
public class JobExeConfig {

    @Value("${spring.datasource.driver-class-name}")
    String driverClass;

    @Value("${spring.datasource.url}")
    String jdbcUrl;

    @Value("${spring.datasource.username}")
    String user;

    @Value("${spring.datasource.password}")
    String password;

    @Value("${xxl.job.executor.ip}")
    String ip;

    @Value("${xxl.job.executor.port}")
    int port;

    @Value("${xxl.job.executor.appname}")
    String appName;



    @Bean("xxlJobDataSource")
    public DataSource xxlJobDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driverClass);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setInitialPoolSize(3);
        dataSource.setMinPoolSize(2);
        dataSource.setMaxPoolSize(10);
        dataSource.setMaxIdleTime(60);
        dataSource.setAcquireRetryDelay(1000);
        dataSource.setAcquireRetryAttempts(10);
        dataSource.setPreferredTestQuery("SELECT 1");
        return dataSource;

    }


    @Bean(value = "xxlJobExecutor",initMethod = "start",destroyMethod = "destroy")
    XxlJobExecutor xxlJobExecutor() throws PropertyVetoException {

        XxlJobExecutor xxlJobExecutor = new XxlJobExecutor();

        xxlJobExecutor.setIp(ip);
        xxlJobExecutor.setPort(port);
        xxlJobExecutor.setAppName(appName);

        DbRegistHelper registHelper = new DbRegistHelper();
        registHelper.setDataSource(xxlJobDataSource());

        xxlJobExecutor.setRegistHelper(registHelper);


        return xxlJobExecutor;

    }

    @Bean("glueFactory")
    GlueFactory glueFactory() throws PropertyVetoException {

        GlueFactory glueFactory =new GlueFactory();

        DbGlueLoader glueLoader = new DbGlueLoader();
        glueLoader.setDataSource(xxlJobDataSource());

        glueFactory.setGlueLoader(glueLoader);

        return glueFactory;

    }

    @PostConstruct
    void test(){
        System.out.println("start");

    }
}
