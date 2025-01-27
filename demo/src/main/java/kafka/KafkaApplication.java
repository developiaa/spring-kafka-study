package kafka;

import kafka.model.Animal;
import kafka.producer.ClipProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;

import java.nio.charset.StandardCharsets;

@Slf4j
@SpringBootApplication
public class KafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);
    }

//    @Bean
//    public ApplicationRunner applicationRunner(KafkaTemplate<String, String> kafkaTemplate) {
//        return args -> {
//            kafkaTemplate.send("quickstart-events", "hello-world");
//        };
//    }

//    @Bean
//    public ApplicationRunner applicationRunner(AdminClient adminClient) {
//        return args -> {
//            Map<String, TopicListing> topics = adminClient.listTopics().namesToListings().get();
//            log.info("========");
//            for (String topicName : topics.keySet()) {
//                TopicListing topicListing = topics.get(topicName);
//                log.info(topicListing.name());
//                Map<String, TopicDescription> description = adminClient.describeTopics(Collections.singleton(topicName)).all().get();
//                log.info(description.keySet().toString());
//
//                // 모든 토픽 삭제
//                if (!topicListing.isInternal()) { // 삭제하면 안됨
////                    adminClient.deleteTopics(Collections.singleton(topicName));
//                }
//            }
//            log.info("========");
//        };
//    }

//    @Bean
//    public ApplicationRunner runner(KafkaTemplate<String, String> kafkaTemplate) {
//        return args -> {
//            kafkaTemplate.send("clip2", "Hello, clip3");
//        };
//    }

    @Bean
    public ApplicationRunner runner2(ClipProducer clipProducer,
                                     KafkaMessageListenerContainer<String, String> kafkaMessageListenerContainer) {
//        return args -> {
//            clipProducer.async("clip2", "Hello, clip3");
//            clipProducer.sync("clip2", "Hello, clip3");
//            clipProducer.routingSend("clip2", "Hello, clip3 routing");
//            clipProducer.routingSendBytes("clip3-bytes", "Hello, clip3-bytes routing".getBytes(StandardCharsets.UTF_8));
//            clipProducer.replyingSend("clip3-request", "Ping Clip3");
//        };
        return args -> {
//            // 시작 - 일시중지 - 재시작 - 중단 : 직접 제어를 하게 되면 장애가 발생시 서버를 내리지 않고 특정 listenerContainer만 중단 가능
//            clipProducer.async("clip4", "Hello Clip4 Container");
//
//            kafkaMessageListenerContainer.start();
//            Thread.sleep(1000L); // 멈추는 데 async하기 때문에
//
//            System.out.println("==== pause ====");
//            kafkaMessageListenerContainer.pause();
//            Thread.sleep(3000L); // 멈추는 데 async하기 때문에
//
//            clipProducer.async("clip5", "Hello Secondly Clip5 Container");
//
//            System.out.println("==== resume ====");
//            kafkaMessageListenerContainer.resume();
//            Thread.sleep(1000L);
//
//            System.out.println("==== stop ====");
//            kafkaMessageListenerContainer.start();


//            clipProducer.async("clip4-listener", "Hello Clip4 Container");
//            clipProducer.async("clip4-animal", new Animal("puppy", 1));
        };
    }
}
