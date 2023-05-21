package net.javaguides.springbootrabbitmqtutorial.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import  org.slf4j.LoggerFactory;

@Service
public class RabbitMQConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQConsumer.class);
    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    private void consume(String message){
        LOGGER.info(String.format("receive msg >>> %s",message));
    }
}
