package com.gmail.danadiadius.config;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.gmail.danadiadius.event.ProductEvent;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Configuration class for Apache Kafka producer setup.
 * Provides Spring beans necessary for producing and sending messages to Kafka topics.
 *
 * @see ProducerFactory
 * @see KafkaTemplate
 * @see ProductEvent
 *
 * @author Dana Khromenko
 * @version 1.0
 * @since 2025
 */

@Configuration
public class KafkaConfig {

    @Bean
    public ProducerFactory<String, ProductEvent> producerFactory() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, String.class);
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(configs);
    }

    @Bean
    public KafkaTemplate<String, ProductEvent> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
