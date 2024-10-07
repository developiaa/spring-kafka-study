package kafka.service.kafka;

import kafka.dto.MyMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.security.auth.callback.Callback;

@RequiredArgsConstructor
@Service
public class KafkaProducerService {
    private static final String TOPIC_NAME = "topic";

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final KafkaTemplate<String, MyMessage> newKafkaTemplate;

    public void sendJson(MyMessage message) {
        newKafkaTemplate.send(TOPIC_NAME, message);
    }


    public void send(String message) {
        kafkaTemplate.send(TOPIC_NAME, message);
    }

    public void sendWithCallback(String message) {
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(TOPIC_NAME, message);
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

            @Override
            public void onSuccess(SendResult<String, String> result) {
                System.out.println("Sent = " + message + " offset : " + result.getRecordMetadata().offset());
            }

            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Failed " + message + " due to : " + ex.getMessage());
            }
        });

    }
}
