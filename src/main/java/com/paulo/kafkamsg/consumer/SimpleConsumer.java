package com.paulo.kafkamsg.consumer;

import com.alibaba.fastjson.JSON;
import com.paulo.kafkamsg.model.MessageEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: create by paulo
 * @version: v1.0
 * @description: com.paulo.kafkamsg.consumer
 * @date:2020/4/15
 */
@Component
public class SimpleConsumer {
    @KafkaListener(topics = "test",containerFactory = "kafkaListenerContainerFactory")
    /**
     * @param message listenerContainerFactory是批量消费，因此ConsumerRecord是一个List，如果不是批量消费的话，相对应就是一个对象。
     * @param acknowledgment 这个参数只有在设置消费者的ack应答模式为AckMode.MANUAL_IMMEDIATE才能注入，意思是需要手动ack。
     */
   /* public void receive(List<MessageEntity> messages, Acknowledgment acknowledgment){
        for (MessageEntity message : messages) {
            System.out.println(JSON.toJSONString(message));
        }
        acknowledgment.acknowledge();
    }*/

    public void receive(MessageEntity message){
        System.out.println("开始消费kafka");
        System.out.println(JSON.toJSONString(message));
    }
}
