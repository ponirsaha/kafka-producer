package com.kafka.producer.controller;

import com.kafka.producer.model.Customer;
import com.kafka.producer.service.MessagePublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer-app")
@RequiredArgsConstructor
public class EventController {

    private final MessagePublisher publisher;

    @PostMapping("/publish")
    public Customer publishMessage(@RequestBody Customer customer) {
        publisher.sendMessageToTopic(customer);
        return customer;
    }

}
