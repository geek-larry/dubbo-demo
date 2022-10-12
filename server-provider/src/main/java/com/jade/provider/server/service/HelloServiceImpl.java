package com.jade.provider.server.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jade.common.api.HelloService;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @date: 2022/10/12
 **/
@Service(interfaceClass = HelloService.class)
@Component
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String message) {
        return "hello," + message;
    }
}
