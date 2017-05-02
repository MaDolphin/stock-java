package com.dolphin.rabbit;

import com.dolphin.util.Convert;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by huang on 2017/4/30.
 */
@Component
public class Receiver {

    @RabbitListener(queues = "respond_execute", containerFactory="rabbitListenerContainerFactory")
    public void process(String context) {
        context = Convert.asciiToString(context);
        System.out.println("[Respond] Get: " + context);
    }

}