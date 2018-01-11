package com.guandou.springcloudapp.controllers;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guandou.springcloudapp.conf.PageBean;
import com.guandou.springcloudapp.dao.mysql.entities.GameLand;
import com.guandou.springcloudapp.dao.mysql.entities.TStudent;
import com.guandou.springcloudapp.dao.mysql.entities.TStudentExample;
import com.guandou.springcloudapp.sercice.GameLandService;
import com.guandou.springcloudapp.sercice.RedisService;
import com.guandou.springcloudapp.sercice.TStudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class IndexController {
    @Autowired
    RedisService redisService;
    @Autowired
    TStudentService tStudentService;
    @Autowired
    GameLandService gameLandService;
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	@RequestMapping("/hello")
	public String hellow() {
        logger.info("启动 hello接口");
       redisService.setStr("test","fdsf");
        TStudent t=new TStudent();
        t.setAge(44);
        t.setName("ces");
        t.setId(32);
        GameLand bean=new GameLand();
        bean.setOrderNo(123);
        bean.setOwnerId("12345");


        PageHelper.startPage(1, 2);
        TStudentExample TS=new TStudentExample();
        List<TStudent> data= tStudentService.findAccountList(TS);
        PageInfo<TStudent> pageInfo = new PageInfo<>(data);

		String getConf="hello, sping Cloud!"+redisService.getStr("test");
		return getConf;
	}

}
