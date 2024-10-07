package kafka.service.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import kafka.dto.MyMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {
    private static final String TOPIC_NAME = "topic5";
    ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "spring-kafka", groupId = "spring-kafka")
    public void consume(String message) {
        log.info("Kafka Consumer consume message : {}", message);
    }

    @KafkaListener(topics = TOPIC_NAME)
    public void listenMessage(String jsonMessage) {
        try {
            MyMessage myMessage = objectMapper.readValue(jsonMessage, MyMessage.class);
            log.info("Kafka Consumer consume message : {}, {}", myMessage.getName(), myMessage.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
