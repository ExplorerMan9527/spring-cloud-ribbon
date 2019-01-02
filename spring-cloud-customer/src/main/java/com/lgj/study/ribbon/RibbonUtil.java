package com.lgj.study.ribbon;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @author guangjie.Liao
 * @Title: RibbonUtil
 * @ProjectName spring-cloud-ribbon
 * @Description: TODO
 * @date 2018/12/2815:29
 */
@Configuration
public class RibbonUtil {
    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public String post(String url, Map<String,String> param){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        if (param ==null){
            return null;
        }
        param.forEach((k,v)->{
            map.add(k,v);
        });
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        ResponseEntity<String> response = this.restTemplate().postForEntity( url, request , String.class );
        return  response.getBody();
    }
}
