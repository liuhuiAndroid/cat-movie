package com.stylefeng.guns.api.cinema.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class FilmFieldVO implements Serializable {

    // 主键编号
    private String fieldId;
    // 开始时间
    private String beginTime;
    // 结束时间
    private String endTime;
    // 电影语言
    private String language;
    // 放映厅名称
    private String hallName;
    // 票价
    private String price;

}
