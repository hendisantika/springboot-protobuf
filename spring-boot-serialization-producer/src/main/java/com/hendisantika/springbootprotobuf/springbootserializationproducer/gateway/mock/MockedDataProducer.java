package com.hendisantika.springbootprotobuf.springbootserializationproducer.gateway.mock;

import com.hendisantika.springbootprotobuf.springbootserializationproducer.gateway.OrderGateway;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-protobuf
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-03-31
 * Time: 06:09
 */

@Component
@Service
public class MockedDataProducer implements OrderGateway {

    private static final int INITIAL_ORDER_ID = 10000000;
    private static final String PERSON_NAME = "John Conceição";
    private static final String ID_PRODUCT_1 = "XXX-2121-333-11";
    private static final String ID_PRODUCT_2 = "YYY-3333-121-21";
    private static final String ID_PRODUCT_3 = "941-6957-219-41";

}
