package com.superwind.test4kafkaproducer.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by jiangxj on 2017/7/8.
 */
@Data
@NoArgsConstructor
public class Message {
    private String id;
    private String msg;
    private Date sendTime;
}
