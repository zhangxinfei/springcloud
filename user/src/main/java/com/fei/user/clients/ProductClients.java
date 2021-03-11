package com.fei.user.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Service
@FeignClient(value = "cloud-product")
public interface ProductClients {

    @GetMapping(value = "/product/getProduct")
    Map<String,Object> getProduct();
}
