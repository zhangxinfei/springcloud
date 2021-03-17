package com.fei.user.config;

import com.fei.user.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: zhangxinfei
 * create at:  2021/3/12  4:18 下午
 * @description: mainConfig
 */
@Configuration
public class MainConfig {


    @Bean
    public User user(){
        return new User("fei",18);
    }
}
