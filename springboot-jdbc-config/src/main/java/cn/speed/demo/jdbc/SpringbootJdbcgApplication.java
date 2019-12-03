package cn.speed.demo.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("cn.speed.demo.jdbc.mapper")
public class SpringbootJdbcgApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJdbcgApplication.class, args);
        System.out.println("--------启动完成------");
    }

}
