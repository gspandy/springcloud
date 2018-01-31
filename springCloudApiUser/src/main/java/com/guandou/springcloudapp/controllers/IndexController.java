package com.guandou.springcloudapp.controllers;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guandou.springcloudapp.base.RespCode;
import com.guandou.springcloudapp.base.RespEntity;
import com.guandou.springcloudapp.conf.PageBean;
import com.guandou.springcloudapp.dao.mysql.entities.GameLand;
import com.guandou.springcloudapp.dao.mysql.entities.TStudent;
import com.guandou.springcloudapp.dao.mysql.entities.TStudentExample;
import com.guandou.springcloudapp.sercice.GameLandService;
import com.guandou.springcloudapp.sercice.RedisService;
import com.guandou.springcloudapp.sercice.TStudentService;
import io.swagger.annotations.*;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Api(value="用户controller",tags={"用户操作接口"})
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
       RespCode.SUCCESS.getCode();
//        +redisService.getStr("test")
        String getConf="hello, sping Cloud!";
		return getConf;
	}
    @ApiOperation(value="创建用户", notes="根据User对象创建用户")

  /*  @ApiImplicitParam(name = "param", value = "用户详细实体user的josn", required = true, dataType = "String")
*/
    @RequestMapping("/hello1")
    public RespEntity hellow1(@RequestParam("param") String param) {
   //public RespEntity hellow1( @RequestBody @ApiParam(name="用户对象",value="传入json格式",required=true) TStudent bean) {


        logger.info("启动 hello1接口");

        RespEntity resq=new RespEntity();
        try{

            TStudentExample TS=new TStudentExample();
            System.out.println(param);
            JSONObject json = JSONObject.fromObject(param);
            RespEntity respEntity=(RespEntity)JSONObject.toBean(json, RespEntity.class);
            List<TStudent> data= tStudentService.findAccountList(TS);
            resq.setRespCode(RespCode.SUCCESS);
            resq.setData(data);
        }catch (Exception e){
            e.printStackTrace();
            resq.setRespCode(RespCode.ERROT);
            resq.setData(e.toString());
        }

        return resq;
    }


}
