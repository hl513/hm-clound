package com.xxx.hep;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.xxx.hep.client.UserClient;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@MapperScan("com.xxx.hep.mapper")
@SpringBootApplication
@EnableFeignClients(clients = {UserClient.class})
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    /**
     * 创建 RestTemplate 并注入容器
     * 远程调用
     * @return
     */
    @Bean
    @LoadBalanced  // eureka 负载均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


    /**
     * 负载均衡策略 一 ：全局使用
     * @return
     */
/*    @Bean
    public IRule randomRule(){
        return new RandomRule();
    }*/
}