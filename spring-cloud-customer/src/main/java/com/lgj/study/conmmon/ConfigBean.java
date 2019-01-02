package com.lgj.study.conmmon;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author guangjie.Liao
 * @Title: ConfigBean
 * @ProjectName spring-cloud-ribbon
 * @Description: TODO
 * @date 2019/1/210:18
 */
@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
