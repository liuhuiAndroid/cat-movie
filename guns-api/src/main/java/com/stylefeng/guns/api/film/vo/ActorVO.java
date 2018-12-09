package com.stylefeng.guns.api.film.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 影片演员信息
 */
@Data
public class ActorVO implements Serializable {

    private String imgAddress;
    private String directorName;
    private String roleName;

}
