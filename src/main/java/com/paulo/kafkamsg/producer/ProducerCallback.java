package com.paulo.kafkamsg.producer;

import com.alibaba.fastjson.JSON;
import com.paulo.kafkamsg.model.MessageEntity;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * @author: create by paulo
 * @version: v1.0
 * @description: com.paulo.kafkamsg.producer
 * @date:2020/4/15
 */
public class ProducerCallback implements ListenableFutureCallback<SendResult<String, MessageEntity>> {
    private final long startTime;
    private final String key;
    private final MessageEntity message;

    public ProducerCallback(long startTime, String key, MessageEntity message) {
        this.startTime = startTime;
        this.key = key;
        this.message = message;
    }

    @Override
    public void onFailure(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onSuccess(SendResult<String, MessageEntity> result) {
        if (result == null) {
            return;
        }

        long time = System.currentTimeMillis() - startTime;
        RecordMetadata recordMetadata = result.getRecordMetadata();
        if (recordMetadata != null) {
            StringBuilder record = new StringBuilder();
            record.append("message(")
                    .append("key = ").append(key).append(",")
                    .append("message = ").append(JSON.toJSON(message)).append(")")
                    .append("send to partition(").append(recordMetadata.partition()).append(")")
                    .append("with offset(").append(recordMetadata.offset()).append(")")
                    .append("in ").append(time).append("ms");
            System.out.println(record);
        }
    }
}
