package com.hendisantika.springbootprotobuf.springbootserializationconsumer.gateway;

import com.hendisantika.springbootprotobuf.springbootserializationconsumer.config.ProducerPropertiesConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-protobuf
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-04-01
 * Time: 06:13
 */
@Component
public class ProducerRestTemplate implements ProducerGateway {
    private final ProducerPropertiesConfiguration producerPropertiesConfiguration;
    private final RestTemplate protoRestTemplate;
    private final RestTemplate defaultRestTemplate;

}
