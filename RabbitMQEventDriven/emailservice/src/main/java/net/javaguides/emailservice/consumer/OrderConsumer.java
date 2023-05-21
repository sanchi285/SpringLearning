package net.javaguides.emailservice.consumer;

import net.javaguides.emailservice.dto.OrderEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@Service
public class OrderConsumer {

    private Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

    @RabbitListener(queues = "${rabbitmq.queue.email.name}")
    public void consume(OrderEvent orderEvent){
            LOGGER.info(String.format("Order event receiver from Email >>>> %s",orderEvent.toString()));
            //email to customer

    }

}
