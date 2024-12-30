package kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ClipConsumer {

    @KafkaListener(id = "clip2-id", topics = "clip2")
    public void listenClip3(String message) {
        log.info(message);
    }

    @KafkaListener(id = "clip3-bytes-id", topics = "clip3-bytes")
    public void listenClip3Bytes(String message) {
        log.info(message);
    }

    @KafkaListener(id = "clip3-request-id", topics = "clip3-request")
    @SendTo // return 되는 타입을 다시 반환
    public String listenClip3Request(String message) {
        log.info(message);
        return "Pong Clip3";
    }
}
