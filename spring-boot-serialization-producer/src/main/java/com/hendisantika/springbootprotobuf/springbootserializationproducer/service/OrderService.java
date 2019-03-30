package com.hendisantika.springbootprotobuf.springbootserializationproducer.service;

import com.hendisantika.springbootprotobuf.springbootserializationproducer.domain.Order;
import com.hendisantika.springbootprotobuf.springbootserializationproducer.gateway.OrderGateway;
import com.hendisantika.springbootprotobuf.springbootserializationproducer.proto.OrdersProto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-protobuf
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-03-31
 * Time: 06:07
 */
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderGateway orderGateway;

    public Collection<Order> getOrders(int totalElements) {
        return orderGateway.regularOrders(totalElements);
    }

    public OrdersProto.Orders getProtobufOrders(int totalElements) {
        return orderGateway.protobufOrders(totalElements);
    }
}