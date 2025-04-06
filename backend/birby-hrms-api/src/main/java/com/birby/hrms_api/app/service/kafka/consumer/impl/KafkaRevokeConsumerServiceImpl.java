package com.birby.hrms_api.app.service.kafka.consumer.impl;

import com.birby.hrms_api.app.constant.KafkaTopics;
import com.birby.hrms_api.app.model.eto.res.RevokeV1ResETO;
import com.birby.hrms_api.app.service.kafka.consumer.KafkaRevokeConsumerService;
import com.birby.hrms_api.app.service.manager.BloomFilterManagerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaRevokeConsumerServiceImpl implements KafkaRevokeConsumerService {
    private final BloomFilterManagerService bloomFilterManagerService;
    private final ObjectMapper objectMapper;
    @Autowired
    public KafkaRevokeConsumerServiceImpl(
            BloomFilterManagerService bloomFilterManagerService,
            ObjectMapper objectMapper
    ){
        this.bloomFilterManagerService = bloomFilterManagerService;
        this.objectMapper = objectMapper;
    }
    @Override
    @KafkaListener(topics = KafkaTopics.REVOKE_ROLE)
    public void listenRevokeRole(String message, ConsumerRecord<String,String> record) {
        try{
            RevokeV1ResETO resETO = objectMapper.readValue(message, RevokeV1ResETO.class);
            bloomFilterManagerService.addBloom(resETO.getUid(),resETO.getRoleIds());
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
        }
    }
}
