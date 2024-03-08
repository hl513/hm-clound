package com.xxx.hep.service;

import com.xxx.hep.client.UserClient;
import com.xxx.hep.mapper.OrderMapper;
import com.xxx.hep.pojo.Order;
import com.xxx.hep.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserClient userClient;

    /**
     *RestTemplate 远程调用 使用 url地址
     */
    /*    public Order queryOrderById(Long orderId) {
            // 1.查询订单
            Order order = orderMapper.findById(orderId);
            // 2、利用 RestTemplate 发起 http请求，完成远程调用  查询用户
            // 2.1 url路径
            String url = "http://localhost:8081/user/"+order.getUserId();
            // 2.2 发送请求
            User user = restTemplate.getForObject(url, User.class);
            // 3、 封装User到 order
            order.setUser(user);
            // 4.返回
            return order;
        }*/

    /**
     * 远程调用服务  使用 eureka提供的服务名
     * @param orderId
     * @return
     */
    /*    public Order queryOrderById(Long orderId) {
            // 1.查询订单
            Order order = orderMapper.findById(orderId);
            // 2、利用 RestTemplate 发起 http请求，完成远程调用  查询用户
            // 2.1 url路径
            String url = "http://userservice/user/"+order.getUserId();
            // 2.2 发送请求
            User user = restTemplate.getForObject(url, User.class);
            // 3、 封装User到 order
            order.setUser(user);
            // 4.返回
            return order;
        }*/

    /**
     * 远程调用服务  使用 fegin
     * @param orderId
     * @return
     */
    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        // 2、利用 Feign 发起 http请求，完成远程调用  查询用户
        User user = userClient.findById(order.getUserId());
        // 3、 封装User到 order
        order.setUser(user);
        // 4.返回
        return order;
    }
}
