package com.yunxi.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @description: TODO
 * @author: qpf
 * @date: 2021/12/8
 * @version: 1.0
 */
@Configuration
@MapperScan("com.yunxi.mall.tiny.mapper")
public class MyBatisConfig {

}
