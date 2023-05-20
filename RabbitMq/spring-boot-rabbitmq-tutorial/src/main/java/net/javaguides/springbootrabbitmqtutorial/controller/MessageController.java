package net.javaguides.springbootrabbitmqtutorial.controller;

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
