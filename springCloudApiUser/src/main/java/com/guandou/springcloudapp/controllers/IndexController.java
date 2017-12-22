package com.guandou.springcloudapp.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	@RequestMapping("/hello")
	public String hellow() {
        logger.info("启动 hello接口");
		String getConf="hello, sping Cloud!";
		return getConf;
	}

}
