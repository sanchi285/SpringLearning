package net.javaguides.springbootrabbitmqtutorial.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    @Value("${rabbitmq.queue.name}")
    private String queue;

    @Value("${rabbit.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.queue.json.name}")
    private String jsonQueue;

    @Value("${rabbitmq.routing.key}")
    private String routingkey;

    @Value("${rabbitmq.routing.json.key}")
    private String routingJsonkey;

    //spring bean for rabbitmqq
    @Bean
    public Queue queue(){
       return new Queue(queue);
    }

    @Bean
    public Queue jsonQueue(){
        return new Queue(jsonQueue);
    }

    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(exchange);
    }

    //binding between queue and exchange using routing key
    @Bean
    public Binding buildeing(){
        return BindingBuilder
                .bind(queue())
                .to(exchange())
                .with(routingkey);
    }

    //binding between jsonqueue and exchange
    @Bean
    public Binding jsonBuildeing(){
        return BindingBuilder
                .bind(jsonQueue())
                .to(exchange())
                .with(routingJsonkey);
    }

    @Bean
    public Jackson2JsonMessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }
}
