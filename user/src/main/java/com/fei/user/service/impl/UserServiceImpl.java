package com.fei.user.service.impl;

import com.fei.user.clients.ProductClients;
import com.fei.user.entity.User;
import com.fei.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author: zhangxinfei
 * create at:  2021/3/18  5:36 下午
 * @description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private ProductClients productClients;

    @Override
    public Map<String,Object> getUser() {
        return productClients.getProduct();
    }
}
