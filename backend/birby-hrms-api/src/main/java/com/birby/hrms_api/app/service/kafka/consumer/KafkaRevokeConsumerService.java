package com.birby.hrms_api.app.service.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface KafkaRevokeConsumerService {
    void listenRevokeRole(String message, ConsumerRecord<String,String> record);
}
