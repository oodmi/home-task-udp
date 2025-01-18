package org.oodmi.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.oodmi.enums.SensorType;
import org.oodmi.service.MessageProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.ip.udp.UnicastReceivingChannelAdapter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessagingException;

@Configuration
public class ListenerConfiguration {
    private final MessageProcessor messageProcessor;

    public ListenerConfiguration(MessageProcessor messageProcessor) {
        this.messageProcessor = messageProcessor;
    }

    @Bean
    public MessageChannel udpHumidityChannel() {
        return new QueueChannel();
    }

    @Bean
    public MessageChannel udpTemperatureChannel() {
        return new QueueChannel();
    }

    @Bean
    public UnicastReceivingChannelAdapter udpHumidityIn() {
        UnicastReceivingChannelAdapter adapter = new UnicastReceivingChannelAdapter(3355);
        adapter.setOutputChannel(udpHumidityChannel());

        return adapter;
    }

    @Bean
    public UnicastReceivingChannelAdapter udpTemperatureIn() {
        UnicastReceivingChannelAdapter adapter = new UnicastReceivingChannelAdapter(3344);
        adapter.setOutputChannel(udpTemperatureChannel());

        return adapter;
    }

    @ServiceActivator(inputChannel = "udpHumidityChannel", async = "true")
    public void handleHumidityMessage(Message<String> message) throws MessagingException {
        messageProcessor.process(message.getPayload(), SensorType.HUMIDITY);
    }

    @ServiceActivator(inputChannel = "udpTemperatureChannel", async = "true")
    public void handleTemperatureMessage(Message<String> message) throws MessagingException {
        messageProcessor.process(message.getPayload(), SensorType.TEMPERATURE);
    }

    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }

}
