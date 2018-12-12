package com.stylefeng.guns.api.cinema.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class AreaVO implements Serializable {

    // 主键编号
    private String areaId;
    // 显示名称
    private String areaName;
    // 是否选中，默认不选中
    private boolean isActive;

}
