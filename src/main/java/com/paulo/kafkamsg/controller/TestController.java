package com.paulo.kafkamsg.controller;

import com.paulo.kafkamsg.model.MessageEntity;
import com.paulo.kafkamsg.producer.SimpleProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: create by paulo
 * @version: v1.0
 * @description: com.paulo.kafkamsg.controller
 * @date:2020/4/15
 */
@RestController
public class TestController {
    @Autowired
    SimpleProducer simpleProducer;

    @GetMapping("/send")
    public void send(){
        MessageEntity message = new MessageEntity();
        message.setTitle("hello");
        message.setBody("content");
        simpleProducer.send("test","test",message);
    }
}
