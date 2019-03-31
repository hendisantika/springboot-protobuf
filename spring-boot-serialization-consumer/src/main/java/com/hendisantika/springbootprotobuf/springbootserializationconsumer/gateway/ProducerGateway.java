package com.hendisantika.springbootprotobuf.springbootserializationconsumer.gateway;

import com.hendisantika.springbootprotobuf.springbootserializationconsumer.domain.Order;
import com.hendisantika.springbootprotobuf.springbootserializationconsumer.proto.OrdersProto;

import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-protobuf
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-04-01
 * Time: 06:07
 */
public interface ProducerGateway {
    OrdersProto.Orders getOrdersProto(int totalElements);

    Collection<Order> getOrders(int totalElements);
}