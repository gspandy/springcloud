package com.guandou.springcloudapp.controllers;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class IndexController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(IndexController.class);
	@RequestMapping("/hello")
	public String hellow() {
		String getConf="hello, sping Cloud!";
		return getConf;
	}

}
