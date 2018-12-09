package com.stylefeng.guns.api.cinema.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class HallTypeVO implements Serializable {
    private String hallTypeId;
    private String hallTypeName;
    private boolean isActive;

}
