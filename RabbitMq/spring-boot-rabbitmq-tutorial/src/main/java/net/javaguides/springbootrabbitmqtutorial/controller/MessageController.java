package net.javaguides.springbootrabbitmqtutorial.controller;

/*
sudo docker run --rm -it -p 15672:15672 -p 5672:5672 rabbitmq:3.11.0-management
 */


import net.javaguides.springbootrabbitmqtutorial.publisher.RabbitMQPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MessageController {
    private RabbitMQPublisher publisher;

    public MessageController(RabbitMQPublisher publisher) {
        this.publisher = publisher;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
        publisher.sendMessage(message);
        return ResponseEntity.ok("messahe sent");
    }
}
