# spring-cloud-ribbon
##1.ribbon 是什么
**Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端负载均衡的工具。**

简单的说，Ribbon是Netflix发布的开源项目，主要功能是提供客户端的软件负载均衡算法，
将Netflix的中间层服务连接在一起。Ribbon客户端组件提供一系列完善的配置项如连接超
时，重试等。简单的说，就是在配置文件中列出Load Balancer（简称LB）后面所有的机器，
Ribbon会自动的帮助你基于某种规则（如简单轮询，随机连接等）去连接这些机器。我们也
很容易使用Ribbon实现自定义的负载均衡算法。

##2.spring cloud 中Ribbon配置使用

**1.导入相应pom文件**
因为Ribbon需要和Eureka 一起使用，所以和Eureka包一起导入。
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-ribbon</artifactId>
</dependency>
```
2.启动类
```java
    @SpringBootApplication
    @EnableDiscoveryClient
    public class SpringCloudCustomerApplication {
        public static void main(String[] args) {
            SpringApplication.run(SpringCloudCustomerApplication.class, args);
        }
    
    }
```
3.加入@LoadBalanced 注解 开启负载均衡
```java
    @Configuration
    public class RibbonUtil {
        @Bean
        @LoadBalanced
        RestTemplate restTemplate(){
            return new RestTemplate();
        }
    }
```
##3.Ribbon 负载均衡策略
