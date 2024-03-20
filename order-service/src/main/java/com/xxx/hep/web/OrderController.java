package com.xxx.hep.web;

import com.xxx.hep.pojo.Order;
import com.xxx.hep.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController {

   @Autowired
   private OrderService orderService;

    @GetMapping("{orderId}")
    public Order queryOrderByUserId(@PathVariable("orderId") Long orderId) {
        // 根据id查询订单并返回
        return orderService.queryOrderById(orderId);
    }


    /**
     * 模拟订单修改功能
     * @return
     */
    @GetMapping("/update")
    public String updateOrder() {
        return "更新订单成功";
    }


    /**
     * 模拟订单时查询商品
     * @return
     */
    @GetMapping("/query")
    public String queryOrder() {
        // 查询商品
        orderService.queryGoods();
        // 查询订单
        System.out.println("查询订单");
        return "查询订单成功";
    }

    /**
     * 新增订单，查询商品
     * @return
     */
    @GetMapping("/save")
    public String saveOrder() {
        // 查询商品
        orderService.queryGoods();
        // 查询订单
        System.err.println("新增订单");
        return "新增订单成功";
    }

}
