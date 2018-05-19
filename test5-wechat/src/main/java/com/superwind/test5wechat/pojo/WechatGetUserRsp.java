package com.superwind.test5wechat.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WechatGetUserRsp extends WechatCommonRsp{
    private Integer total;
    private Integer count;
    private WechatUserVarData data;
    @JsonProperty("next_openid")
    private String nextOpenid;
}
