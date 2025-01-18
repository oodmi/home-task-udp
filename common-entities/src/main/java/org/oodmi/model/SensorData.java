package org.oodmi.model;


import org.oodmi.enums.SensorType;

import java.util.StringJoiner;

public final class SensorData {
    private String sensorId;
    private int value;
    private SensorType sensorType;

    public SensorData(String sensorId, int value, SensorType sensorType) {
        this.sensorId = sensorId;
        this.value = value;
        this.sensorType = sensorType;
    }

    public SensorData() {
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public SensorType getSensorType() {
        return sensorType;
    }

    public void setSensorType(SensorType sensorType) {
        this.sensorType = sensorType;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SensorData.class.getSimpleName() + "[", "]")
                .add("sensorId='" + sensorId + "'")
                .add("value=" + value)
                .add("sensorType=" + sensorType)
                .toString();
    }
}
