package com.birby.hrms_account_api.app.service.common;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface KafkaProducerService {
    void sendMessage(String topic,Object data) throws JsonProcessingException;
}
