package org.oodmi.service;

import org.oodmi.model.SensorData;
import org.oodmi.properties.AlarmProperties;

public abstract class AlarmService {

    private final AlarmProperties alarmProperties;

    protected AlarmService(AlarmProperties alarmProperties) {
        this.alarmProperties = alarmProperties;
    }

    public void raiseAlarmIfNeed(SensorData sensorData) {
        Integer threshold = alarmProperties.getThresholds().get(sensorData.getSensorType());

        if (sensorData.getValue() >= threshold) {
            raiseAlarm(getAlarmMessage(sensorData, threshold));
        }
    }

    private String getAlarmMessage(SensorData sensorData, Integer threshold) {
        return "Attention! Maximum value for sensor "
                + sensorData.getSensorId() + ": " + threshold
                + ". Current value: " + sensorData.getValue();
    }

    protected abstract void raiseAlarm(String alarm);


}
