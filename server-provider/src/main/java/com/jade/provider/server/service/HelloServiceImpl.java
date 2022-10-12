package com.jade.provider.server.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.cluster.loadbalance.RoundRobinLoadBalance;
import com.jade.common.api.HelloService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @date: 2022/10/12
 **/
@Service(interfaceClass = HelloService.class,loadbalance = RoundRobinLoadBalance.NAME,timeout = 1000)
@Component
public class HelloServiceImpl implements HelloService {

    @Override
    @HystrixCommand(fallbackMethod = "defaultHello")
    public String hello(String message) {
        String a = null;
        a.toString();
        return "hello," + message;
    }

    public String defaultHello(String message) {
        return "hello hystrix";
    }
}
