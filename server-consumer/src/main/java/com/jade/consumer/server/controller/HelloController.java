package com.jade.consumer.server.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.rpc.cluster.loadbalance.RoundRobinLoadBalance;
import com.jade.common.api.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @date: 2022/10/12
 **/
@RestController
public class HelloController {

    @Reference(loadbalance = RoundRobinLoadBalance.NAME)
    private HelloService helloService;

    @GetMapping("/hello/{message}")
    public String hello(@PathVariable String message) {
        return this.helloService.hello(message);
    }
}
