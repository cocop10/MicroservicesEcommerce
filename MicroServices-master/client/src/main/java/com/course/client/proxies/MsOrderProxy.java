package com.course.client.proxies;

import com.course.client.beans.OrderBean;
import com.course.client.beans.OrderItemBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@FeignClient(name = "ms-order", url = "localhost:8086")
public interface MsOrderProxy {

    @PostMapping(value ="/order")
    ResponseEntity<OrderBean> createNewOrder(@RequestBody OrderBean orderData);

    @GetMapping(value="/order/{id}")
    Optional<OrderBean> getOrder(@PathVariable Long id);

    @PostMapping(value = "/cart/{id}")
    ResponseEntity<OrderItemBean> addOrderItemToOrder (@PathVariable Long id, @RequestBody OrderItemBean orderItem);
}
