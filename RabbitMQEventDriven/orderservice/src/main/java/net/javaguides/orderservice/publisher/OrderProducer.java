package net.javaguides.orderservice.publisher;
import net.javaguides.orderservice.dto.OrderEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

@Service
public class OrderProducer {
    private Logger LOGGER = LoggerFactory.getLogger(OrderProducer.class);


    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.binding.routing.key}")
    private String routingKey;

    @Value("${rabbitmq.binding.email.routing.key}")
    private String emailroutingKey;


    private RabbitTemplate rabbitTemplate;

    public OrderProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(OrderEvent orderEvent){
        LOGGER.info(String.format("OrderEvent Sent to Raqbbitmq %s",orderEvent.toString()));
        rabbitTemplate.convertAndSend(exchange,routingKey,orderEvent);

        //send evento to email
        rabbitTemplate.convertAndSend(exchange,emailroutingKey,orderEvent);

    }
}
