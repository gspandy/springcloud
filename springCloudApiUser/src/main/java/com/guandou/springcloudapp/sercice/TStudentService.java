package com.guandou.springcloudapp.sercice;

import com.guandou.springcloudapp.dao.mysql.entities.TStudent;
import com.guandou.springcloudapp.dao.mysql.entities.TStudentExample;
import com.guandou.springcloudapp.dao.mysql.mapper.TStudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TStudentService {

    @Autowired
    private TStudentMapper accountMapper;

    public int add(TStudent t) {
        return accountMapper.insert(t);
    }
    public int update(TStudent t) {
        return accountMapper.updateByPrimaryKey(t);
    }
    public int delete(int id) {
        return accountMapper.deleteByPrimaryKey(id);
    }
    public TStudent findAccount(TStudentExample example) {
        return accountMapper.selectByExample(example).get(0);
    }
    public List<TStudent> findAccountList(TStudentExample example) {
        return accountMapper.selectByExample(example);
    }
}
