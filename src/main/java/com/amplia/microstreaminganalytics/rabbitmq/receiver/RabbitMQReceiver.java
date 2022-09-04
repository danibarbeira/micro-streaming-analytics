package com.amplia.microstreaminganalytics.rabbitmq.receiver;

import com.amplia.microstreaminganalytics.rabbitmq.message.CustomMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * RabbitMQ message receiver class.
 */
@Service
public class RabbitMQReceiver {

    private static final Logger log = LoggerFactory.getLogger(RabbitMQReceiver.class);

    /**
     * Receiver listener method. Listening for messages on the queue amplia.queue and when received, processes the message.
     *
     * @param message Message received from the corresponding queue.
     */
    @RabbitListener(queues = "amplia.queue")
    public void receiveMessage(final CustomMessage message) {
        log.info("Received message and deserialized to 'CustomMessage' -> {}", message.toString());
    }

}
