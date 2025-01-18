package org.oodmi.service;

import org.oodmi.enums.SensorType;
import org.oodmi.model.SensorData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProcessor {

    private static final Logger log = LoggerFactory.getLogger(MessageProcessor.class);
    private final KafkaTemplate<String, SensorData> kafkaTemplate;
    private final SensorParser sensorParser;

    public MessageProcessor(KafkaTemplate<String, SensorData> kafkaTemplate, SensorParser sensorParser) {
        this.kafkaTemplate = kafkaTemplate;
        this.sensorParser = sensorParser;
    }

    public void process(String message, SensorType sensorType) {
        SensorData sensorData = sensorParser.parseSensorData(message);
        sensorData.setSensorType(sensorType);

        kafkaTemplate.send("sensors", sensorData);
    }
}
