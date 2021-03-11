package com.fei.user.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: zhangxinfei
 * create at:  2021/3/11  4:51 下午
 * @description: MybatisPlusConfig
 */
@Configuration
@MapperScan("com.fei.user.mapper")
public class MybatisPlusConfig {

    /**
     *     分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
