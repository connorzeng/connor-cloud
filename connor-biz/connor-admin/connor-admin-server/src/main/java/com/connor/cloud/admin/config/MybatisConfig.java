package com.connor.cloud.admin.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.connor.cloud.admin.dao.mapper")
public class MybatisConfig {



}
