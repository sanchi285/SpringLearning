package net.javaguides.springbootrabbitmqtutorial.publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.slf4j.Logger;
import  org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQPublisher {
    @Value("${rabbit.exchange.name}")
    private String exchange;

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQPublisher.class);

    @Value("${rabbitmq.routing.key}")
    private String routingkey;

    private RabbitTemplate rabbitTemplate;

    public RabbitMQPublisher(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message){
        LOGGER.info(String.format("Message->sent %s",message));
        rabbitTemplate.convertAndSend(exchange,routingkey,message);
    }
}
