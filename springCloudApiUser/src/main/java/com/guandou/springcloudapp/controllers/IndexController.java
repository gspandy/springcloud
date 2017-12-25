package com.guandou.springcloudapp.controllers;

import com.guandou.springcloudapp.dao.mysql.entities.TStudent;
import com.guandou.springcloudapp.sercice.RedisService;
import com.guandou.springcloudapp.sercice.TStudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @Autowired
    RedisService redisService;
    @Autowired
    TStudentService tStudentService;
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	@RequestMapping("/hello")
	public String hellow() {
        logger.info("启动 hello接口");
      /*  redisService.setStr("test","fdsf");*/
        TStudent t=new TStudent();
        t.setAge(44);
        t.setName("ces");
        t.setId(44);
        tStudentService.add(t);
		String getConf="hello, sping Cloud!";
		return getConf;
	}

}
