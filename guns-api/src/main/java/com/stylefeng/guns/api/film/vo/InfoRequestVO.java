package com.stylefeng.guns.api.film.vo;

import lombok.Data;

@Data
public class InfoRequestVO {

    private String biography;
    private ActorRequestVO actors;
    private ImgVO imgVO;
    private String filmId;

}
