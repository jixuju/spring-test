package com.superwind.service;

import com.superwind.pojo.UserInfo;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by jiangxj on 2018/4/11.
 */
@Service
public class UserService {
    public UserInfo qryUser(UserInfo userInfo) {
        UserInfo userRsp = new UserInfo();
        userRsp.setNick("zhangsan");
        userRsp.setCreateTime(new Date());
        return userRsp;
    }
}
