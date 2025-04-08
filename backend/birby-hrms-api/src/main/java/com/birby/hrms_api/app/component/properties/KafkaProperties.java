package com.birby.hrms_api.app.component.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "kafka-config")
public class KafkaProperties {
    private String brokerUrl;
    private String groupId;
}
