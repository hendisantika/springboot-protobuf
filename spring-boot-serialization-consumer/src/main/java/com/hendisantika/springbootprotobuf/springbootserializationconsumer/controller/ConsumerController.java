package com.hendisantika.springbootprotobuf.springbootserializationconsumer.controller;

import com.hendisantika.springbootprotobuf.springbootserializationconsumer.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

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


}