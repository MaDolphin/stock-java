package com.dolphin.rabbit;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * Created by huang on 2017/4/30.
 */

@Component
public class Sender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String context) {
        this.rabbitTemplate.convertAndSend("require_execute", context);
        System.out.println("[Require] Send: " + context);
    }

}