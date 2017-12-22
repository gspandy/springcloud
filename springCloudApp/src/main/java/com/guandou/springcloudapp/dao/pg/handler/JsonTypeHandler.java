/**
 * guandou.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.guandou.springcloudapp.dao.pg.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;


/**
 *
 * @author guandou1
 * @version id: JsonTypHandler, v 0.1 17/5/11 上午10:00 guandou1 Exp $$
 */
@MappedJdbcTypes(JdbcType.OTHER)
@MappedTypes(String.class)
public class JsonTypeHandler extends BaseTypeHandler<Object> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Object o,
                                    JdbcType jdbcType) throws SQLException {
        if (o == null) {
            preparedStatement.setNull(i, Types.OTHER);
        } else {


        }
    }

    @Override
    public Object getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return resultSet.getString(s);
    }

    @Override
    public Object getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return resultSet.getString(i);
    }

    @Override
    public Object getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return callableStatement.getString(i);
    }
}
