package com.baizhi.fl;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;


/**
 * Created by lenovo on 2018/7/4.
 */


@SpringBootApplication
@MapperScan(value = "com.baizhi.fl.dao")
public class CmfzApplication {
    public static void main(String[] args) {
        SpringApplication.run(CmfzApplication.class,args);
    }


}
