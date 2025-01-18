package org.oodmi.service;

import org.oodmi.model.SensorData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SensorParser {

    private static final Logger log = LoggerFactory.getLogger(SensorParser.class);

    public SensorData parseSensorData(String input) {
        SensorData sensorData = new SensorData();

        try {
            // Split the input string by "; " to separate key-value pairs
            String[] parts = input.split("; ");

            for (String part : parts) {
                part = part.strip();
                // Split each key-value pair by "="
                String[] keyValue = part.split("=");
                String key = keyValue[0];
                String value = keyValue[1];

                // Map to fields in SensorData
                if (key.equals("sensor_id")) {
                    sensorData.setSensorId(value);
                } else if (key.equals("value")) {
                    sensorData.setValue(Integer.parseInt(value));
                }
            }
        } catch (Exception e) {
            log.error("Failed to parse sensor data: ", e);
        }

        return sensorData;
    }
}