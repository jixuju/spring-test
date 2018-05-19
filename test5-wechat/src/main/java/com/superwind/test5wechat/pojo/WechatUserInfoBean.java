package com.superwind.test5wechat.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@ToString
public class WechatUserInfoBean extends WechatCommonRsp{
    private Integer subscribe;
    @JsonProperty("openid")
    private String openId;
    @JsonProperty("nickname")
    private String nick;
    private Byte sex;
    private String language;
    private String city;
    private String province;
    private String country;
    @JsonProperty("headimgurl")
    private String headImage;
    @JsonProperty("subscribe_time")
    private Date subscribeTime;
    @JsonProperty("unionid")
    private String unionId;
    private String remark;
    @JsonProperty("groupid")
    private Integer groupId;
    @JsonProperty("tagid_list")
    private List<Integer> tagidList;
    @JsonProperty("privilege")
    private List<String> privilege;
}
