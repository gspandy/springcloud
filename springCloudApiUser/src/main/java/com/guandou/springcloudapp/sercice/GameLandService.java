package com.guandou.springcloudapp.sercice;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guandou.springcloudapp.dao.mysql.entities.GameLand;
import com.guandou.springcloudapp.dao.mysql.entities.TStudent;
import com.guandou.springcloudapp.dao.mysql.entities.TStudentExample;
import com.guandou.springcloudapp.dao.mysql.mapper.GameLandMapper;
import com.guandou.springcloudapp.dao.mysql.mapper.TStudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameLandService {

    @Autowired
    private GameLandMapper mapper;

    public List<GameLand> getByGradeNm(String name){
        return mapper.getByGradeNm("dff");
    };
    public List<GameLand> getListByBean(GameLand bean){
        PageHelper.startPage(1, 6);

        return mapper.getListByBean(bean);
    };
    public PageInfo<GameLand> getList(GameLand bean){
        PageHelper.startPage(1, 6);
        List<GameLand> data=mapper.getListByBean(bean);
        return new PageInfo<GameLand>(data) ;
    };
    public Boolean save(GameLand bean){
        return mapper.saveBean(bean);
    };

}
