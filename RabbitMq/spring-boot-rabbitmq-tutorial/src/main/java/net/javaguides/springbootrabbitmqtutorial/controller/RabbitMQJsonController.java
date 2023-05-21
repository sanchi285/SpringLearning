package net.javaguides.springbootrabbitmqtutorial.controller;


import net.javaguides.springbootrabbitmqtutorial.dto.User;
import net.javaguides.springbootrabbitmqtutorial.publisher.RabbitMQJsonProducer;
import net.javaguides.springbootrabbitmqtutorial.publisher.RabbitMQPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class RabbitMQJsonController {
    private RabbitMQJsonProducer rabbitMQJsonProducer;

    public RabbitMQJsonController(RabbitMQJsonProducer jsonProducer){
        this.rabbitMQJsonProducer=jsonProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user){
      rabbitMQJsonProducer.sendJsonMessage(user);
        return ResponseEntity.ok("Json message sent");
    }
}
