package com.amplia.microstreaminganalytics.rabbitmq.sender;

import com.amplia.microstreaminganalytics.rabbitmq.message.CustomMessage;
import com.amplia.microstreaminganalytics.rabbitmq.message.DataPoint;
import com.amplia.microstreaminganalytics.rabbitmq.message.DataStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Random;

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
    @Scheduled(fixedRate = 20000, initialDelay = 4000)
    public void send() {
        final CustomMessage customMessage = this.createCustomMessage();
        log.info("Fixed rate task - " + System.currentTimeMillis() / 1000);
        log.info(String.format("Sending message -> %s", customMessage.toString()));
        rabbitTemplate.convertAndSend(topicExchangeName, routingKey, customMessage);
    }

    private CustomMessage createCustomMessage() {
        CustomMessage customMessage = new CustomMessage();
        ArrayList<DataStream> dataStreams = new ArrayList<>();
        ArrayList<DataPoint> dataPoints;
        DataStream dataStream;
        Random random = new Random();

        int i, j;

        for (i = 0; i < 3; i++) {
            dataStream = new DataStream();
            dataPoints = new ArrayList<>();
            dataStream.setId("datastream_".concat(String.valueOf(i)));
            dataStream.setFeed("feed_".concat(String.valueOf(i)));
            for (j = 0; j < 3; j++) {
                dataPoints.add(new DataPoint(Instant.now().toEpochMilli(), random.nextInt(100)));
            }
            dataStream.setDatapoints(dataPoints);
            dataStreams.add(dataStream);
        }

        customMessage.setVersion("1.0.0");
        customMessage.setDevice(String.format("OpenGate device %s", random.nextInt(1000)));
        customMessage.setDatastreams(dataStreams);

        return customMessage;
    }

}
