//package cn.speed.demo.jdbc.config;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//
///**
// * Created by jingxingqiang on 2019/12/4 21:50
// */
//@Configuration
//public class JdbcConfig3 {
//    @Bean
//    @ConfigurationProperties(prefix = "spring")
//    public DataSource getDataSource(){
//        DruidDataSource dataSource = new DruidDataSource();
//        return dataSource;
//    }
//}
