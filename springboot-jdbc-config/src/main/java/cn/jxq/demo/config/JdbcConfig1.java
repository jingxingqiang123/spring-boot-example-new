//package cn.speed.demo.jdbc.config;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//
//import javax.sql.DataSource;
//
///**
// * java配置 - 01
// * 利用@valu注入，只能注入基本类型
// * Created by jingxingqiang on 2019/12/4 20:48
// *
// * @Configuration：声明我们`JdbcConfig`是一个配置类
// * @PropertySource：指定属性文件的路径是:`classpath:jdbc.properties
// * 通过@Value为属性注入值
// * 通过@Bean将 dataSource()方法声明为一个注册Bean的方法，
// *   Spring会自动调用该方法，将方法的返回值加入Spring容器中
// */
//@Configuration
//@PropertySource("classpath:jdbc.properties")
//public class JdbcConfig1 {
//
//    @Value("$jdbc.driverClassName}")
//    private String driverClassName;
//    @Value("${jdbc.url}")
//    private String url;
//    @Value("${jdbc.username}")
//    private String username;
//    private String password;
//
//    @Bean
//    public DataSource getDataSource() {
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setUrl(url);
//        dataSource.setDriverClassName(driverClassName);
//        dataSource.setUsername(username);
//        dataSource.setPassword(password);
//        return dataSource;
//    }
//
//}
