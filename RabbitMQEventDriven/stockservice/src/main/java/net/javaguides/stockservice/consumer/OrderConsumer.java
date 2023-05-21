package net.javaguides.stockservice.consumer;

import net.javaguides.stockservice.dto.OrderEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


@Service
public class OrderConsumer {
    private Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);
    @RabbitListener(queues = "${rabbitmq.queue.order.name}")
    public void consume(OrderEvent event){
        LOGGER.info(String.format("Order Event received => %s",event.toString()));
        //save in to data base
    }
}
