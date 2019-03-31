package com.hendisantika.springbootprotobuf.springbootserializationconsumer.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-protobuf
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-04-01
 * Time: 06:03
 */
@ConfigurationProperties(value = "app.config")
@Data
@Component
public class ProducerPropertiesConfiguration {
    private String producerProtobufUrl;
    private String producerJsonUrl;
}
