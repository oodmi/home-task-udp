package org.oodmi.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.oodmi.enums.SensorType;
import org.oodmi.model.SensorData;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class LoggerAlarmServiceTest {

    @MockitoSpyBean
    private LoggerAlarmService loggerAlarmService;

    @Test
    void doNotRaiseAlarmTest() {
        SensorData sensorData = new SensorData("t1", 10, SensorType.TEMPERATURE);
        loggerAlarmService.raiseAlarmIfNeed(sensorData);

        Mockito.verify(loggerAlarmService, Mockito.times(0)).raiseAlarm(Mockito.any());
    }
    @Test
    void raiseAlarmTest() {
        SensorData sensorData = new SensorData("t1", 35, SensorType.TEMPERATURE);
        loggerAlarmService.raiseAlarmIfNeed(sensorData);

        Mockito.verify(loggerAlarmService, Mockito.times(1)).raiseAlarm(Mockito.any());
    }
}