package com.pandie.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * 入口类 博客出处：http://www.cnblogs.com/GoodHelper/
 *
 */
@Configuration//配置控制
@SpringBootApplication
@EnableAutoConfiguration//启用自动配置
@ComponentScan(value={"com.pandie.springcloud"})//组件扫描
public class App extends WebMvcConfigurerAdapter{
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}



}
