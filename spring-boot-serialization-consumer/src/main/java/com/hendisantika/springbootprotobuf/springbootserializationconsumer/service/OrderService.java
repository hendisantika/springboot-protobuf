package com.hendisantika.springbootprotobuf.springbootserializationconsumer.service;

import com.hendisantika.springbootprotobuf.springbootserializationconsumer.domain.Order;
import com.hendisantika.springbootprotobuf.springbootserializationconsumer.gateway.ProducerGateway;
import com.hendisantika.springbootprotobuf.springbootserializationconsumer.proto.OrdersProto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-protobuf
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-04-01
 * Time: 06:10
 */
@Service
@RequiredArgsConstructor
public class OrderService {

    private final ProducerGateway producerGateway;

    public Collection<Order> getOrders(int totalElements) {
        return producerGateway.getOrders(totalElements);
    }

    public OrdersProto.Orders getProtobufOrders(int totalElements) {
        return producerGateway.getOrdersProto(totalElements);
    }
}