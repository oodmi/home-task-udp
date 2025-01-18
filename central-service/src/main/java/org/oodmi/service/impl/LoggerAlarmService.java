package org.oodmi.service.impl;

import org.oodmi.properties.AlarmProperties;
import org.oodmi.service.AlarmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LoggerAlarmService extends AlarmService {

    private static final Logger log = LoggerFactory.getLogger(LoggerAlarmService.class);

    protected LoggerAlarmService(AlarmProperties alarmProperties) {
        super(alarmProperties);
    }

    @Override
    public void raiseAlarm(String alarm) {
        log.info(alarm);
    }
}
