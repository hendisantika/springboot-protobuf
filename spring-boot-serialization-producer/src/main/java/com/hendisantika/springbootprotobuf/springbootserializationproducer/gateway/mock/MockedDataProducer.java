package com.hendisantika.springbootprotobuf.springbootserializationproducer.gateway.mock;

import com.hendisantika.springbootprotobuf.springbootserializationproducer.domain.Order;
import com.hendisantika.springbootprotobuf.springbootserializationproducer.domain.Person;
import com.hendisantika.springbootprotobuf.springbootserializationproducer.domain.Product;
import com.hendisantika.springbootprotobuf.springbootserializationproducer.domain.ProductType;
import com.hendisantika.springbootprotobuf.springbootserializationproducer.gateway.OrderGateway;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.stream.IntStream;

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

    @Override
    public Collection<Order> regularOrders(int totalElements) {
        final Collection<Order> orderCollection = new ArrayList<>(totalElements);

        IntStream.range(0, totalElements)
                .forEach(
                        iteration -> {
                            final Product product1 =
                                    Product.builder()
                                            .id(ID_PRODUCT_1)
                                            .productType(ProductType.COMMON)
                                            .priceInCents(new Random().nextInt(PRICE_IN_CENTS))
                                            .build();

                            final Product product2 =
                                    Product.builder()
                                            .id(ID_PRODUCT_2)
                                            .productType(ProductType.COMMON)
                                            .priceInCents(new Random().nextInt(PRICE_IN_CENTS))
                                            .build();

                            final Product product3 =
                                    Product.builder()
                                            .id(ID_PRODUCT_3)
                                            .productType(ProductType.COMMON)
                                            .priceInCents(new Random().nextInt(PRICE_IN_CENTS))
                                            .build();

                            final Person person = Person.builder().name(PERSON_NAME).build();

                            final Order order =
                                    Order.builder()
                                            .orderId(String.valueOf(INITIAL_ORDER_ID + iteration))
                                            .person(person)
                                            .productCollection(Arrays.asList(product1, product2, product3))
                                            .build();
                            orderCollection.add(order);
                        });

        return orderCollection;
    }

}
