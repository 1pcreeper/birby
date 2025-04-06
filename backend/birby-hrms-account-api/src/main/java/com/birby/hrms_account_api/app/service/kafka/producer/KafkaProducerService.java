package com.birby.hrms_account_api.app.service.kafka.producer;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface KafkaProducerService {
    void sendMessage(String topic,Object data) throws JsonProcessingException;
}
