package com.stylefeng.guns.api.cinema.vo;

import lombok.Data;

@Data
public class CinemaVO {

    // 主键编号
    private String uuid;
    // 影院名称
    private String cinemaName;
    // 影院地址
    private String address;
    // 最低票价
    private String minimumPrice;

}
