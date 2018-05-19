package com.superwind.test5wechat.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TokenOperReq{
    private String operType;
    private String token;
    private String reserv1;
    private String reserv2;
}
