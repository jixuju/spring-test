package com.superwind.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by jiangxj on 2018/4/11.
 */
@Data
@NoArgsConstructor
public class UserInfo {
    private String userName;
    private Byte sex;
    private String nick;
    private String regionCode;
    private String company;
    private String address;
    private Date birthday;
    private Date createTime;
}
