package net.javaguides.orderservice.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    //spring bean for queue - order queue
    @Value("${rabbitmq.queue.order.name}")
    private String orderQueue;

    @Value("${rabbitmq.queue.email.name}")
    private String emailQueue;



    @Value("${rabbitmq.exchange.name}")
    private String exchange;


    @Value("${rabbitmq.binding.routing.key}")
    private String routingkey;


    @Value("${rabbitmq.binding.email.routing.key}")
    private String emailRoutingkey;


    @Bean
    public Queue orderQueue(){
        return new Queue(orderQueue);
    }


    @Bean
    public Queue emailQueue(){
        return new Queue(emailQueue);
    }

    //spring bean for queue - exchange
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(exchange);
    }


    //bean for binging exchange between queue and routingh keyu

    @Bean
    public Binding binding(){
        return BindingBuilder.bind(orderQueue())
                .to(exchange())
                .with(routingkey);

    }

    @Bean
    public Binding emailbinding(){
        return BindingBuilder.bind(emailQueue())
                .to(exchange())
                .with(emailRoutingkey);

    }


    //message converter
    @Bean
    public MessageConverter converter(){
       return new Jackson2JsonMessageConverter();
    }

    //configure rabbit template
    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }


}
