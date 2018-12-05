package com.stylefeng.guns.api.film;

import com.stylefeng.guns.api.film.vo.*;

import java.util.List;

public interface FilmServiceApi {
    //获取首页banner
    List<BannerVO> getBanners();

    //获取热门影片
    FilmVO getHotFilms(boolean isLimit, int nums);

    //获取不久后上映
    FilmVO getSoonFilms(boolean isLimit, int nums);


    //获取票房排行榜
    List<FilmInfo> getBoxRanking();


    //获取人气排行榜
    List<FilmInfo> getExpectRanking();


    //获取前100的影片
    List<FilmInfo> getTop();

    // ==== 获取影片条件接口
    // 分类条件
    List<CatVO> getCats();
    // 片源条件
    List<SourceVO> getSources();
    // 获取年代条件
    List<YearVO> getYears();

}
