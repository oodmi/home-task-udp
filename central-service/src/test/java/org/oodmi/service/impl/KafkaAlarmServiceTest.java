package org.oodmi.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.oodmi.enums.SensorType;
import org.oodmi.model.SensorData;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class KafkaAlarmServiceTest {

    @MockitoSpyBean
    private KafkaAlarmService kafkaAlarmService;

    @Test
    void doNotRaiseAlarmTest() {
        SensorData sensorData = new SensorData("h1", 10, SensorType.HUMIDITY);
        kafkaAlarmService.raiseAlarmIfNeed(sensorData);

        Mockito.verify(kafkaAlarmService, Mockito.times(0)).raiseAlarm(Mockito.any());
    }
    @Test
    void raiseAlarmTest() {
        SensorData sensorData = new SensorData("h1", 50, SensorType.HUMIDITY);
        kafkaAlarmService.raiseAlarmIfNeed(sensorData);

        Mockito.verify(kafkaAlarmService, Mockito.times(1)).raiseAlarm(Mockito.any());
    }
}