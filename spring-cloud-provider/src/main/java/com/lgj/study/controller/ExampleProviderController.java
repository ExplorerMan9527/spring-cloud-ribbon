package com.lgj.study.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guangjie.Liao
 * @Title: ExampleProvider
 * @ProjectName spring-cloud-ribbon
 * @Description: TODO
 * @date 2018/12/2815:21
 */
@RestController
@RequestMapping(value = "/provider")
public class ExampleProviderController {

    @Value("${name}")
    private String providerName ;

    @RequestMapping(value = "/test")
    public String test(String name){
        return "你好！"+name+" "+providerName+" 为您服务!";
    }
}
