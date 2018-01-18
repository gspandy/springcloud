package com.guandou.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.core.env.Environment;

/**
 * Spring could conf程序主入口
 * @author Administrator
 *
 */
@SpringBootApplication
@EnableConfigServer
public class Application {


	public static void main(String[] args) {   
        SpringApplication.run(Application.class,args);   
    }   
}
