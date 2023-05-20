package net.javaguides.springbootrabbitmqtutorial.publisher;

import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import net.javaguides.springbootrabbitmqtutorial.dto.User;

@Service
public class RabbitMQJsonProducer {
    @Value("${rabbit.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.json.key}")
    private String routingJsonKey;

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonProducer.class);
    private RabbitTemplate rabbitTemplate;

    public RabbitMQJsonProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate =rabbitTemplate;
    }

    public void sendJsonMessage(User user){
        LOGGER.info(String.format("Json Message has been Sent>> %s",user.toString()));
        rabbitTemplate.convertAndSend(exchange,routingJsonKey, user);
    }
}
