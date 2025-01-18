package org.oodmi.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.oodmi.enums.SensorType;
import org.oodmi.model.SensorData;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class MessageProcessorTest {

    @MockitoSpyBean
    private MessageProcessor messageProcessor;

    @Test
    void processWrongDataTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            messageProcessor.process("sensor_id:h1; value:40", SensorType.HUMIDITY);
        });
    }

    @Test
    void processTest() {
        messageProcessor.process("sensor_id=h1; value=40", SensorType.HUMIDITY);
    }
}