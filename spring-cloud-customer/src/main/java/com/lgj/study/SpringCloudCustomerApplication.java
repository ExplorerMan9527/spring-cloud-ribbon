package com.lgj.study;

import com.lgj.config.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableDiscoveryClient
//自定义类MyRule类不能放在@ComponeScan 所扫描包下，即启动类包下，
// 否则会导致自定义规则呗所有Robbin客户端共享
@RibbonClient(name ="PROVIDER",configuration = MyRule.class)
public class SpringCloudCustomerApplication {
    public static void main(String[] args) {
		SpringApplication.run(SpringCloudCustomerApplication.class, args);
	}
}

