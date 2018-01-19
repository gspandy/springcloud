package com.guandou.springcloudapp.controllers;

import com.guandou.springcloudapp.dao.mysql.entities.TStudent;
import com.guandou.springcloudapp.dao.mysql.entities.TStudentExample;
import com.guandou.springcloudapp.dao.mysql.mapper.TStudentMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class IndexController {
    @Autowired
    private TStudentMapper accountMapper;
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(IndexController.class);
	@RequestMapping("/hello")
	public String hellow() {
		String getConf="hello, sping Cloud!";
        TStudentExample TS=new TStudentExample();
        List<TStudent> data= accountMapper.selectByExample(TS);
		return getConf+data;
	}
    @Value("${db.mysql.password}")
    private String appName;

    @RequestMapping("/app-name")
    public String getAppName() {
        return appName;
    }
 @RequestMapping(value = { "/api/app/test" }, method = { RequestMethod.POST }, produces="application/json;charset=UTF-8")
 @ResponseBody
public String cancelCall(HttpServletResponse rsp) {
         rsp.addHeader("Access-Control-Allow-Origin", "*");
      return "";
         }
}
