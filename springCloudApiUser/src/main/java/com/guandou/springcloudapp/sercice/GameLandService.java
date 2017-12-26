package com.guandou.springcloudapp.sercice;

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
        return mapper.getListByBean(bean);
    };
    public Boolean save(GameLand bean){
        return mapper.saveBean(bean);
    };

}
