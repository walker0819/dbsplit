package com.josh.dbseparated.dao;

import com.josh.dbseparated.entity.SysLog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SysLogDaoTest {
    @Autowired
    private SysLogDao sysLogDao;
    @Test
    public void insertLog() {

    }

    @Test
    public void queryById() {
        SysLog sysLog = new SysLog();
        sysLog.setId(23);
        sysLogDao.queryById(sysLog);
    }
}