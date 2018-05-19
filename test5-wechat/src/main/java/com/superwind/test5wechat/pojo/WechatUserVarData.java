package com.superwind.test5wechat.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class WechatUserVarData {
    private List<String> openid;
}
