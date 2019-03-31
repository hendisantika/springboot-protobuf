package com.hendisantika.springbootprotobuf.springbootserializationconsumer.controller;

import com.hendisantika.springbootprotobuf.springbootserializationconsumer.domain.Order;
import com.hendisantika.springbootprotobuf.springbootserializationconsumer.proto.OrdersProto;
import com.hendisantika.springbootprotobuf.springbootserializationconsumer.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-protobuf
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-04-01
 * Time: 06:09
 */
@RestController
@RequiredArgsConstructor
@Slf4j
public class ConsumerController {

    private final OrderService orderService;

    @GetMapping("/order/{totalElement}")
    public ResponseEntity<Collection<Order>> getOrders(@PathVariable int totalElement) {
        final StopWatch stopWatch = new StopWatch();
        stopWatch.start("getOrders");

        final Collection<Order> orders = orderService.getOrders(totalElement);

        stopWatch.stop();
        log.info("Total time in milliseconds getOrders: {}", stopWatch.getLastTaskTimeMillis());

        return ResponseEntity.ok(orders);
    }

    @GetMapping(value = "/order/proto/{totalElement}")
    public OrdersProto.Orders getOrdersProto(@PathVariable int totalElement) {
        final StopWatch stopWatch = new StopWatch();
        stopWatch.start("getOrdersProto");

        final OrdersProto.Orders protobufOrders = orderService.getProtobufOrders(totalElement);

        stopWatch.stop();
        log.info("Total time in milliseconds getOrdersProto: {}", stopWatch.getLastTaskTimeMillis());
        return protobufOrders;
    }



}