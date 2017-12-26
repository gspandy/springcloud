package com.guandou.springcloudapp;

import com.guandou.springcloudapp.dao.mysql.entities.GameLand;

import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

public class SqlGameLand {

    public String selectByBean(GameLand bean) {
        StringBuffer sb = new StringBuffer("select * from game_land t where 1=1 ");
        if (!StringUtils.isEmpty(bean.getId())) {
            sb.append("and t.id='" + bean.getId() + "' ");
        } else if (!StringUtils.isEmpty(bean.getOwnerId())) {

        } else {

        }
        return sb.toString();
    }
    public String insertBlog(GameLand bean){
        SQL sql = new SQL(); //SQL语句对象，所在包：org.apache.ibatis.jdbc.SQL

        sql.INSERT_INTO("game_land");
        if (!StringUtils.isEmpty(bean.getOwnerId())) {
            sql.VALUES("owner_id", bean.getOwnerId());
        }
        if (!StringUtils.isEmpty(bean.getOrderNo())) {
            sql.VALUES("order_no", bean.getOrderNo()+"");
        }
        return sql.toString();
    }


    public String insertBean(final GameLand bean)
    {
        return new SQL() {{
            INSERT_INTO("game_land");
            if (bean.getOwnerId() != null) {
                VALUES("owner_id", "#{ownerId}");
            }
            if (bean.getOrderNo() != null) {
                VALUES("order_no", "#{orderNo}");
            }
        }}.toString();
    }
}
