package com.guandou.springcloudapp.main;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Spring could web程序主入口
 * @author Administrator
 *
 */
@Configuration//配置控制  
@EnableAutoConfiguration//启用自动配置  
@ComponentScan(value={"com.guandou.springcloudapp"})//组件扫描
@EnableDiscoveryClient
@EnableEurekaClient

public class Application {
    //配置mybatis的分页插件pageHelper


    public static Logger logger= LoggerFactory.getLogger(Application.class);
	public static void main(String[] args) {   
        /* 第一个简单的应用， */
        SpringApplication.run(Application.class,args);

    }   
}
