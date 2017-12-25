package com.pandie.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 入口类 博客出处：http://www.cnblogs.com/GoodHelper/
 *
 */
@Configuration//配置控制
@SpringBootApplication
@EnableAutoConfiguration//启用自动配置
@ComponentScan(value={"com.pandie.springcloud"})//组件扫描
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
