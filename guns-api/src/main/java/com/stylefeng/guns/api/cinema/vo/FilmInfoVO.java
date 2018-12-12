package com.stylefeng.guns.api.cinema.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class FilmInfoVO implements Serializable {

    // 电影编号
    private String filmId;
    // 电影名称
    private String filmName;
    // 电影时长
    private String filmLength;
    // 电影类型
    private String filmType;
    // 电影类型
    private String filmCats;
    // 演员列表
    private String actors;
    // 图片地址
    private String imgAddress;
    // 影片信息
    private List<FilmFieldVO> filmFields;

}
