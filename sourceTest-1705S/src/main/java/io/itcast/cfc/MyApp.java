package io.itcast.cfc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@MapperScan("io.itcast.cfc.dao")
//@EnableAsync
public class MyApp {
    public static void main(String[] args) {
        SpringApplication.run(MyApp.class,args);
    }
}
