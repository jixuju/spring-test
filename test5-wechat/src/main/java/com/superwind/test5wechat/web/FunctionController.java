package com.superwind.test5wechat.web;

import com.superwind.test5wechat.util.WechatUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * 微信公众号access_token
 */
@Slf4j
@RestController
public class FunctionController {

    @Autowired
    private WechatUtil wechatUtil;


}
