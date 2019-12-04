package cn.jxq.demo.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by jingxingqiang on 2019/12/4 21:23
 */
@Configuration
@EnableConfigurationProperties(JdbcProperties.class)
public class JdbcConfig2 {

    @Bean
    public DataSource getDatasource(JdbcProperties jdbc) {

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(jdbc.getUrl());
        dataSource.setPassword(jdbc.getPassword());
        dataSource.setUsername(jdbc.getUsername());
        dataSource.setDriverClassName(jdbc.getDriverClassName());
        return dataSource;

    }
}
