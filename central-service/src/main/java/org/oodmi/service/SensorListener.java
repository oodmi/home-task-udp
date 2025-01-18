package org.oodmi.service;

import org.oodmi.model.SensorData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SensorListener {

    private static final Logger log = LoggerFactory.getLogger(SensorListener.class);

    private final AlarmService loggerAlarmService;
    private final AlarmService kafkaAlarmService;

    public SensorListener(@Qualifier("loggerAlarmService") AlarmService loggerAlarmService,
                          @Qualifier("kafkaAlarmService") AlarmService kafkaAlarmService) {
        this.loggerAlarmService = loggerAlarmService;
        this.kafkaAlarmService = kafkaAlarmService;
    }

    @KafkaListener(topics = "sensors")
    public void process(SensorData sensorData) {
        log.info("Received: {}", sensorData);

        loggerAlarmService.raiseAlarmIfNeed(sensorData);
        kafkaAlarmService.raiseAlarmIfNeed(sensorData);
    }

}
