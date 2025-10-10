package com.hendisantika.springbootprotobuf.springbootserializationconsumer.domain;

import lombok.Getter;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-protobuf
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-04-01
 * Time: 06:01
 */
@Getter
public enum ProductType {

    GIFT(0),
    COMMON(1);

    private final int type;

    ProductType(int type) {
        this.type = type;
    }
}