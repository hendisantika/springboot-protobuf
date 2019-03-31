package com.hendisantika.springbootprotobuf.springbootserializationconsumer.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-protobuf
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-04-01
 * Time: 06:04
 */
@Configuration
@RequiredArgsConstructor
public class RestTemplateConfig {

    private final ProtobufHttpMessageConverter protobufHttpMessageConverter;

    @Bean
    RestTemplate protoRestTemplate() {
        return new RestTemplate(Collections.singletonList(protobufHttpMessageConverter));
    }

    @Bean
    RestTemplate defaultRestTemplate() {
        return new RestTemplate();
    }
}