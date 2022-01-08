package study.devleopia.kafka.service.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {

    @KafkaListener(topics = "spring-kafka", groupId = "spring-kafka")
    public void consume(String message) {
        log.info("Kafka Consumer consume message : {}", message);
    }
}
