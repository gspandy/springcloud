package com.guandou.springcloudapp.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

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
    @Autowired
    void setEnviroment(Environment env) {
        System.out.println("my-config.appName from env: "
                + env.getProperty("db.mysql.password"));
    }
	public static void main(String[] args) {   
        //第一个简单的应用，   
        SpringApplication.run(Application.class,args);   
    }   
}
