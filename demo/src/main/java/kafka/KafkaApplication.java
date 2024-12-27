package kafka;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner(KafkaTemplate<String, String> kafkaTemplate) {
        return args -> {
            kafkaTemplate.send("quickstart-events", "hello-world");
        };
    }

}
