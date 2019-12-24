package com.josh.dbseparated.dao;

import com.josh.dbseparated.entity.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SysLogDao {

    @Insert("insert into sys_log(username,operation) values(#{username}, #{operation})")
    Integer insertLog(SysLog sysLog);

    @Select("select * from sys_log where id= #{id}")
    public SysLog queryById(SysLog sysLog);
}
