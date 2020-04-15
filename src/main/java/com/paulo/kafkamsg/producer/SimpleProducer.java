package com.paulo.kafkamsg.producer;

import com.paulo.kafkamsg.model.MessageEntity;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import javax.annotation.Resource;

/**
 * @author: create by paulo
 * @version: v1.0
 * @description: com.paulo.kafkamsg.producer
 * @date:2020/4/15
 */
@Component
public class SimpleProducer {
    @Resource
    private KafkaTemplate<String, MessageEntity> kafkaTemplate;

    public void send(String topic,String key,MessageEntity msg){
        ProducerRecord<String,MessageEntity> record = new ProducerRecord(
                topic,
                key,
                msg
        );

        long start = System.currentTimeMillis();
        ListenableFuture<SendResult<String, MessageEntity>> future = kafkaTemplate.send(record);
        future.addCallback(new ProducerCallback(start,key,msg));
    }
}
