package com.paulo.kafkamsg.model;

import lombok.Data;
import lombok.ToString;

/**
 * @author: create by paulo
 * @version: v1.0
 * @description: com.paulo.kafkamsg.model
 * @date:2020/4/15
 */
@Data
@ToString
public class MessageEntity {
    /**
     * 标题
     */
    private String title;
    /**
     * 消息
     */
    private String body;
}
