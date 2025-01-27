package kafka.consumer;

import kafka.model.Animal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.adapter.ConsumerRecordMetadata;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
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

    @KafkaListener(id = "clip4-listener", topics = "clip4-listener", concurrency = "2", clientIdPrefix = "listener-id")
    public void listen(String message, @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long timestamp,
                       @Header(KafkaHeaders.OFFSET) long offset,
                       @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                       @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partitionId,
                       ConsumerRecordMetadata metadata) {
        log.warn("listener!!!!!!!!!!!! message : {}", message);
        System.out.println(metadata.topic());
        System.out.println(timestamp);
        System.out.println(offset);
        System.out.println(partitionId);
        System.out.println(topic);
    }


    @KafkaListener(id = "clip4-animal-listener", topics = "clip4-animal")
    public void listenAnimal(Animal animal) {
        System.out.println("Animal = " + animal);
    }

}
