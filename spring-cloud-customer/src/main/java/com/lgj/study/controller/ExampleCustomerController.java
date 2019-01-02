package com.lgj.study.controller;

import com.lgj.study.ribbon.RibbonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author guangjie.Liao
 * @Title: ExampleCustomerController
 * @ProjectName spring-cloud-ribbon
 * @Description: TODO
 * @date 2018/12/2815:26
 */
@RestController
@RequestMapping(value = "/customer")
public class ExampleCustomerController {

    @Autowired
    private RibbonUtil ribbonUtil;

    @RequestMapping(value = "/test")
    public String test(){
        Map<String,String> param = new HashMap<>();
        param.put("name","廖广杰");
        String postResult = ribbonUtil.post("http://PROVIDER/provider/test",param);
        return  postResult;
    }
}
