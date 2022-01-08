package study.devleopia.kafka.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import study.devleopia.kafka.service.kafka.KafkaProducer;

@Slf4j
@RequestMapping(value = "/v1/api/kafka")
@RequiredArgsConstructor
@RestController
public class KafkaController {
    private final KafkaProducer producer;

    @PostMapping
    public String sendMessage(@RequestParam String message) {
        this.producer.sendMessage(message);
        return "success";
    }
}
