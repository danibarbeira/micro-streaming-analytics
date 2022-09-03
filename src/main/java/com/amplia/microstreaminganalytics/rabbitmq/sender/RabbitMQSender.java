package com.amplia.microstreaminganalytics.rabbitmq.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * RabbitMQ message sender class.
 */
@Service
public class RabbitMQSender {

    private static final Logger log = LoggerFactory.getLogger(RabbitMQSender.class);

    @Value("${amplia.rabbitmq.exchange}")
    String topicExchangeName;

    @Value("${amplia.rabbitmq.routingkey}")
    String routingKey;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * Scheduled task that sends a message to the defined topic exchange using the corresponding routing key.
     */
    @Scheduled(fixedRate = 10000, initialDelay = 4000)
    public void send() {
        log.info("Fixed rate task - " + System.currentTimeMillis() / 1000);
        log.info("Sending message...");
        rabbitTemplate.convertAndSend(topicExchangeName, routingKey, "HELLO WORLD!");
    }

}
