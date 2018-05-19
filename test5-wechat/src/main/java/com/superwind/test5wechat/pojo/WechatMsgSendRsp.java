package com.superwind.test5wechat.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WechatMsgSendRsp extends WechatCommonRsp{
    private Long msgid;
}
