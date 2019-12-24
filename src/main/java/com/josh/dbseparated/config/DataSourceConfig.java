package com.josh.dbseparated.config;

import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;


@Configuration
public class DataSourceConfig {
    private Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);
    @Autowired
    private MasterProperties masterProperties;

    @Autowired
    private SlaveProperties slaveProperties;

    @Bean(name = "masterDataSource")
    @Primary
    public DataSource masterProperties() {
        logger.info("masterDatasource初始化");
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(masterProperties.getUrl());
        dataSource.setUsername(masterProperties.getUsername());
        dataSource.setPassword(masterProperties.getPassword());
        dataSource.setDriverClassName(masterProperties.getDriverClassName());
        return dataSource;
    }

    @Bean(name = "slaveDataSource")
    public DataSource dataBase2DataSource() {
        logger.info("slaveDataSource初始化");
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(slaveProperties.getUrl());
        dataSource.setUsername(slaveProperties.getUsername());
        dataSource.setPassword(slaveProperties.getPassword());
        dataSource.setDriverClassName(slaveProperties.getDriverClassName());
        return dataSource;
    }
}
