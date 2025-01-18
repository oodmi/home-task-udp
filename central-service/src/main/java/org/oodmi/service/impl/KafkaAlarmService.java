package org.oodmi.service.impl;

import org.oodmi.properties.AlarmProperties;
import org.oodmi.service.AlarmService;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaAlarmService extends AlarmService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    protected KafkaAlarmService(AlarmProperties alarmProperties, KafkaTemplate<String, String> kafkaTemplate) {
        super(alarmProperties);
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void raiseAlarm(String alarm) {
        kafkaTemplate.send("notification", alarm);
    }
}
