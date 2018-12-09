package com.stylefeng.guns.api.film.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 影片描述信息
 */
@Data
public class FilmDescVO implements Serializable {

    private String biography;
    private String filmId;

}
