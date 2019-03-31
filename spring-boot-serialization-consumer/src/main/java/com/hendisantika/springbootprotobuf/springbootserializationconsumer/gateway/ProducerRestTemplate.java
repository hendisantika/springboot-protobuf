package com.hendisantika.springbootprotobuf.springbootserializationconsumer.gateway;

import com.hendisantika.springbootprotobuf.springbootserializationconsumer.config.ProducerPropertiesConfiguration;
import com.hendisantika.springbootprotobuf.springbootserializationconsumer.proto.OrdersProto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

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

    @Autowired
    public ProducerRestTemplate(ProducerPropertiesConfiguration producerPropertiesConfiguration,
                                @Qualifier("protoRestTemplate") RestTemplate protoRestTemplate,
                                @Qualifier("defaultRestTemplate") RestTemplate defaultRestTemplate) {
        this.producerPropertiesConfiguration = producerPropertiesConfiguration;
        this.protoRestTemplate = protoRestTemplate;
        this.defaultRestTemplate = defaultRestTemplate;
    }

    @Override
    public OrdersProto.Orders getOrdersProto(int totalElements) {

        final URI uri = UriComponentsBuilder.fromHttpUrl(producerPropertiesConfiguration.getProducerProtobufUrl())
                .path(String.valueOf(totalElements))
                .build().encode().toUri();

        final RequestEntity<Void> requestEntity = RequestEntity
                .get(uri)
                .build();

        final ResponseEntity<OrdersProto.Orders> responseEntity = protoRestTemplate.exchange(requestEntity, OrdersProto.Orders.class);
        return responseEntity.getBody();
    }

}
