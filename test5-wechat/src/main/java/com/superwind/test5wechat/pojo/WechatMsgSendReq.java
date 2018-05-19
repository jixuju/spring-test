package com.superwind.test5wechat.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@NoArgsConstructor
public class WechatMsgSendReq {
    @JsonProperty("touser")
    private String toUser;
    @JsonProperty("template_id")
    private String templateId;
    private String url;
    @JsonProperty("topcolor")
    private String topColor;
    private HashMap<String,WechatMsgVarData> data;
}
