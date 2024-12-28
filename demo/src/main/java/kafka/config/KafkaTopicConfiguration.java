package kafka.config;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class KafkaTopicConfiguration {
    @Bean
    public AdminClient adminClient(KafkaAdmin kafkaAdmin) {
        // 카프카 정보 가져오기
        return AdminClient.create(kafkaAdmin.getConfigurationProperties());
    }

    @Bean
    public NewTopic topic() {
        // 기본적인 디폴트 설정으로 생성
        return TopicBuilder.name("clip2")
                .build();
    }

    @Bean
    public KafkaAdmin.NewTopics topics() {
        return new KafkaAdmin.NewTopics(
                TopicBuilder.name("clip2-part1").build(),
                TopicBuilder.name("clip2-part2")
                        .partitions(3) // 내부 코드에서 확인 - 다른 설정은 안바뀌고 파티션의 개수만 변경 가능
                        .replicas(1)
                        .config(TopicConfig.RETENTION_MS_CONFIG, String.valueOf(1000 * 60 * 60))
                        .build()
        );
    }
}
