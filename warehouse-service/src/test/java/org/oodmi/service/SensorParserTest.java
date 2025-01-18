package org.oodmi.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.oodmi.model.SensorData;

class SensorParserTest {

    @Test
    void parseSensorDataTest() {
        SensorData sensorData = new SensorParser().parseSensorData("sensor_id=h1; value=40");

        Assertions.assertEquals("h1", sensorData.getSensorId());
        Assertions.assertEquals(40, sensorData.getValue());
    }

    @Test
    void parseSensorDataErrorTest() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SensorParser().parseSensorData("sensor_id=h 1; value=l0");
        });

    }
}