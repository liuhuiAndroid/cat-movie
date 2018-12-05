package com.stylefeng.guns.api.film.vo;

import lombok.Data;

import java.io.Serializable;

/*
电影信息
 */
@Data
public class FilmInfo implements Serializable {
    private String filmId;
    private int filmType;
    private String imgAddress;
    private String filmName;
    private String filmScore;
    private int expectNum;
    private String showTime;
    private int boxNum;
    private String score;
}
