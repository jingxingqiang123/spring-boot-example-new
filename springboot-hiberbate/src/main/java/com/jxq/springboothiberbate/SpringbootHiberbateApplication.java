package com.jxq.springboothiberbate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SpringbootHiberbateApplication {
        private static Logger log = LoggerFactory.getLogger(SpringbootHiberbateApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(SpringbootHiberbateApplication.class, args);
        log.info("---------启动完毕-------");
    }

}
