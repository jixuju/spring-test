package com.superwind.test3rabbitmq.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by jiangxj on 2017/9/3.
 */
@Data
@NoArgsConstructor
public class UserInfo {
    private Integer id;
    private String name;
    private Short sex;
}
