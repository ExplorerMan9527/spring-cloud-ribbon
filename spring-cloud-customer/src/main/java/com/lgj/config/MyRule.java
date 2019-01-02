package com.lgj.config;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author guangjie.Liao
 * @Title: MyRule
 * @ProjectName spring-cloud-ribbon
 * @Description: TODO
 * @date 2019/1/217:34
 */
@Configuration
public class MyRule {

    @Bean
    public IRule myRule(){
        return new PollFiveRule();
    }
}
