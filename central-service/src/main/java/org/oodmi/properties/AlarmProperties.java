package org.oodmi.properties;

import org.oodmi.enums.SensorType;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties("alarm")
public class AlarmProperties {

    private Map<SensorType, Integer> thresholds;

    public Map<SensorType, Integer> getThresholds() {
        return thresholds;
    }

    public AlarmProperties setThresholds(Map<SensorType, Integer> thresholds) {
        this.thresholds = thresholds;
        return this;
    }
}
