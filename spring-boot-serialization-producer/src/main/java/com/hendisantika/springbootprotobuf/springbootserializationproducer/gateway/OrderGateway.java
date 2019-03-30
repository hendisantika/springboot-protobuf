package com.hendisantika.springbootprotobuf.springbootserializationproducer.gateway;

import com.hendisantika.springbootprotobuf.springbootserializationproducer.domain.Order;
import com.hendisantika.springbootprotobuf.springbootserializationproducer.proto.OrdersProto;

import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-protobuf
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-03-31
 * Time: 06:02
 */
public interface OrderGateway {

    Collection<Order> regularOrders(int totalElements);

    OrdersProto.Orders protobufOrders(int totalElements);
}
