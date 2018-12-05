package com.stylefeng.guns.api.film.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
/*
首页信息
 */

@Data
public class FilmIndexVO implements Serializable {

    private List<BannerVO> banners;//首页banners

    private FilmVO hotFilms;//热门电影

    private FilmVO soonFilms;//即将上映

    private List<FilmInfo> boxRanking;//获取票房排行榜

    private List<FilmInfo> expectRanking;//人气排行榜

    private List<FilmInfo> top100;//前100的影片排行


}
