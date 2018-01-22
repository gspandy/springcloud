package com.pandie.springcloud;


import com.pandie.springcloud.enity.RespCode;
import com.pandie.springcloud.enity.RespEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class JsonUtils {


    @Autowired
    private RestTemplate restTemplate;

    public  RespEntity getRespEntityByUrl(String url,String json){

        RespEntity rs=new RespEntity();

        try{
            rs= restTemplate.getForObject(url+"?param={json}", RespEntity.class, json);
        }catch (Exception e) {
            // TODO: handle exception
            rs.setRespCode(RespCode.ERROT);
            e.printStackTrace();


        }
        return  rs;
    }

}
