package com.superwind.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserBean{
    private Byte operType;
    private Integer id;
    private String sex;
    private String name;
}
