package kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.TopicDescription;
import org.apache.kafka.clients.admin.TopicListing;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.Collections;
import java.util.Map;

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

    @Bean
    public ApplicationRunner applicationRunner(AdminClient adminClient) {
        return args -> {
            Map<String, TopicListing> topics = adminClient.listTopics().namesToListings().get();
            log.info("========");
            for (String topicName : topics.keySet()) {
                TopicListing topicListing = topics.get(topicName);
                log.info(topicListing.name());
                Map<String, TopicDescription> description = adminClient.describeTopics(Collections.singleton(topicName)).all().get();
                log.info(description.keySet().toString());

                // 모든 토픽 삭제
                if (!topicListing.isInternal()) { // 삭제하면 안됨
//                    adminClient.deleteTopics(Collections.singleton(topicName));
                }
            }
            log.info("========");
        };
    }

}
