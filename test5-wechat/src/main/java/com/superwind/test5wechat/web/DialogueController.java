package com.superwind.test5wechat.web;

import com.superwind.test5wechat.conf.WechatProperties;
import com.superwind.test5wechat.exception.CommonException;
import com.superwind.test5wechat.pojo.TokenOperReq;
import com.superwind.test5wechat.pojo.TokenOperRsp;
import com.superwind.test5wechat.pojo.WechatGetUserReq;
import com.superwind.test5wechat.pojo.WechatGetUserRsp;
import com.superwind.test5wechat.pojo.WechatMsgSendReq;
import com.superwind.test5wechat.pojo.WechatMsgSendRsp;
import com.superwind.test5wechat.pojo.WechatUserInfoBean;
import com.superwind.test5wechat.util.WechatUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 微信公众号access_token
 */
@Slf4j
@RestController
public class DialogueController {

    @Autowired
    private WechatUtil wechatUtil;
    @Autowired
    private WechatProperties wechatProperties;

    /**
     * 获取token
     * @param tokenOperReq
     * @return
     */
    @PostMapping("/wechat/token")
    public TokenOperRsp wechatToken(@RequestBody TokenOperReq tokenOperReq) {
        TokenOperRsp tokenOperRsp = new TokenOperRsp();

        String token = tokenOperReq.getToken();
        String operType = tokenOperReq.getOperType();
        if ("1".equals(operType)) {         //设置新token
            wechatUtil.setInfraToken(token);
            tokenOperRsp.setToken(token);
        } else if ("2".equals(operType)) {  //获取当前token
            String accessToken = wechatUtil.getInfraToken(wechatProperties.getAppid(),wechatProperties.getAppsecret());
            tokenOperRsp.setToken(accessToken);
        } else if ("3".equals(operType)) {      //清除token缓存
            wechatUtil.removeInfraTokenInRedis();
            tokenOperRsp.setToken("");
        } else {
            throw new CommonException("不支持的操作类型!");
        }
        return tokenOperRsp;
    }

    /**
     * 发送模板消息
     * @param wechatMsgSendReq
     * @return
     */
    @PostMapping("/wechat/message/tpl/send")
    public WechatMsgSendRsp sendTplMessage(@RequestBody String wechatMsgSendReq) {
//        String accessToken = wechatUtil.getInfraToken(wechatProperties.getAppid(),wechatProperties.getAppsecret());
        return wechatUtil.sendTplMessage("");
    }

    /**
     * 获取用户列表
     * @return
     */
    @PostMapping("/wechat/user/getList")
    public WechatGetUserRsp getUserList(@RequestBody WechatGetUserReq wechatGetUserReq) {
        String accessToken = wechatUtil.getInfraToken(wechatProperties.getAppid(),wechatProperties.getAppsecret());
        return wechatUtil.getUserList(accessToken, wechatGetUserReq.getOpenId());
    }

    /**
     * 获取用户信息
     * @param wechatGetUserReq
     * @return
     */
    @PostMapping("/wechat/user/get")
    public WechatUserInfoBean getUserInfo(@RequestBody WechatGetUserReq wechatGetUserReq) {
        String accessToken = wechatUtil.getInfraToken(wechatProperties.getAppid(),wechatProperties.getAppsecret());
        return wechatUtil.getUserInfo(accessToken, wechatGetUserReq.getOpenId());
    }

}
