package com.kafka.producer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessagePublisher {

    private final KafkaTemplate<String, Object> template;

    public void sendMessageToTopic(String message) {
        CompletableFuture<SendResult<String, Object>> future = template.send("3rd-topic", message);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                log.info("Send message =>> [{}] and Topic =>> [{}] with offset =>> [{}] and Partition =>> [{}]",
                        message, result.getRecordMetadata().topic(), result.getRecordMetadata().offset(),
                        result.getRecordMetadata().partition());
            } else {
                log.error("Unable to send message =>> [{}] due to =>> [{}]", message, ex.getMessage());
            }
        });
    }
}
