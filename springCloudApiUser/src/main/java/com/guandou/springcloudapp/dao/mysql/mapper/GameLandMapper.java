package com.guandou.springcloudapp.dao.mysql.mapper;


import com.guandou.springcloudapp.SqlGameLand;
import com.guandou.springcloudapp.dao.mysql.entities.GameLand;
import org.apache.ibatis.annotations.*;
import org.springframework.jdbc.core.SqlProvider;

import java.util.List;


public interface GameLandMapper {
    @Select("select * from game_land where 1=1")
    @Results({
            @Result(property = "userSex",  column = "user_sex"),
            @Result(property = "nickName", column = "nick_name")
    })
    public List<GameLand> getByGradeNm(String name);
    @SelectProvider(type = GameLand.class, method = "selectByBean")
    public List<GameLand> getListByBean(GameLand bean);
@Insert("insert into grade(grade_nm,teacher_id) values(#{gradeNm},#{teacherId})")
    @Options(useGeneratedKeys=true,keyColumn="id",keyProperty="id")//设置id自增长
    public void save(GameLand grade);
    @InsertProvider(type = GameLand.class,method = "insertBean")
    public boolean saveBean(GameLand bean);
}
