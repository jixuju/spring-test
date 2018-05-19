package com.superwind.test5wechat.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The response of wechat access_token
 */
@Data
@NoArgsConstructor
public class WechatInfraTokenBean extends WechatCommonRsp{
    @JsonProperty("access_token")
    private String accessToken;
    /** 凭证有效时间，单位：秒 */
    @JsonProperty("expires_in")
    private int expiresIn;

}
