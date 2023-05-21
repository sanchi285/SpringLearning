package net.javaguides.emailservice.config;

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
    @Value("${rabbitmq.queue.email.name}")
    private String orderQueue;

    @Value("${rabbitmq.exchange.name}")
    private String exchange;


    @Value("${rabbitmq.binding.email.routing.key}")
    private String routingkey;


    @Bean
    public Queue orderQueue(){
        return new Queue(orderQueue);
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
