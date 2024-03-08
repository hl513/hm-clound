package com.xxx.hep.client;

import com.xxx.hep.config.DefaultFeignConfiguration;
import com.xxx.hep.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// 服务名称：userservice  第二个参数为配置日志  加在这里为单个服务有效，加在启动类上为全局有效
@FeignClient(value = "userservice",configuration = DefaultFeignConfiguration.class)
public interface UserClient {
    @GetMapping("/user/{id}")
    User findById(@PathVariable("id") Long id);
}