package com.stylefeng.guns.rest.modular.film;


import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.api.film.FilmServiceApi;
import com.stylefeng.guns.api.film.vo.CatVO;
import com.stylefeng.guns.api.film.vo.FilmIndexVO;
import com.stylefeng.guns.rest.modular.vo.ResponseVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/film/")
public class FilmController {
    private static final String img_pre = "http://img.meetingshop.cn/";

    @Reference(interfaceClass = FilmServiceApi.class)
    private FilmServiceApi filmServiceApi;

    //首页的获取
    @RequestMapping(value = "getIndex",method = RequestMethod.GET)
    public ResponseVO getIndex() {
        FilmIndexVO filmIndexVO=new FilmIndexVO();
        //获取首页banner
        filmIndexVO.setBanners(filmServiceApi.getBanners());

        //获取热门影片
        filmIndexVO.setHotFilms(filmServiceApi.getHotFilms(true,8));
        //获取不久后上映
        filmIndexVO.setSoonFilms(filmServiceApi.getSoonFilms(true,8));
        //获取票房排行榜
        filmIndexVO.setBoxRanking(filmServiceApi.getBoxRanking());

        //获取人气排行榜
        filmIndexVO.setExpectRanking(filmServiceApi.getExpectRanking());
        //获取前100的影片
        filmIndexVO.setTop100(filmServiceApi.getTop());

        return ResponseVO.success(filmIndexVO,img_pre);
    }
    @RequestMapping(value = "getConditionList",method = RequestMethod.GET)
    public ResponseVO getConditionList(@RequestParam(name = "catId",required = false,defaultValue = "99")String catId,
                                       @RequestParam(name = "sourceId",required = false,defaultValue = "99")String sourceId,
                                       @RequestParam(name = "yearId",required = false,defaultValue = "99")String yearId){

        List<CatVO> cats = filmServiceApi.getCats();

        return null;
    }
}
