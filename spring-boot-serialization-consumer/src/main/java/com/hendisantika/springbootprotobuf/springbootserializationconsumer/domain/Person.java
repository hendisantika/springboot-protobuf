package com.hendisantika.springbootprotobuf.springbootserializationconsumer.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-protobuf
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-04-01
 * Time: 06:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String name;
}