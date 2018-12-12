package com.stylefeng.guns.api.cinema.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class HallInfoVO implements Serializable {

    // 主键编号
    private String hallFieldId;
    // 放映厅名称
    private String hallName;
    // 票价
    private String price;
    // 座位文件存放地址
    private String seatFile;
    // TODO 已售座位必须关联订单才能查询
    private String soldSeats;

}
