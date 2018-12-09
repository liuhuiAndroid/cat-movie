package com.stylefeng.guns.api.user.vo;


import lombok.Data;

import java.io.Serializable;

/**
 * 用户信息，排除敏感信息
 */
@Data
public class UserInfoModel implements Serializable{

    private Integer uuid;
    private String username;
    private String nickname;
    private String email;
    private String phone;
    private int sex;
    private String birthday;
    private String lifeState;
    private String biography;
    private String address;
    private String headAddress;
    private long beginTime;
    private long updateTime;

}