package com.stylefeng.guns.rest.modular.film.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.api.film.FilmServiceApi;
import com.stylefeng.guns.api.film.vo.*;
import com.stylefeng.guns.core.util.DateUtil;
import com.stylefeng.guns.rest.common.persistence.dao.*;
import com.stylefeng.guns.rest.common.persistence.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;



@Component
@Service(interfaceClass = FilmServiceApi.class)
public class DefaultFilmServiceImpl  implements FilmServiceApi {

    @Autowired
    MoocBannerTMapper moocBannerTMapper;
    @Autowired
    MoocFilmTMapper moocFilmTMapper;
    @Autowired
    private MoocCatDictTMapper moocCatDictTMapper;

    @Autowired
    private MoocYearDictTMapper moocYearDictTMapper;

    @Autowired
    private MoocSourceDictTMapper moocSourceDictTMapper;


    @Override
    public List<BannerVO> getBanners() {

        List<BannerVO> result = new ArrayList<>();
        List<MoocBannerT> moocBanners=moocBannerTMapper.selectList(null);
        for(MoocBannerT moocBannerT : moocBanners){
            BannerVO  bannerVO=new BannerVO();
            bannerVO.setBannerUrl(moocBannerT.getBannerUrl());
            bannerVO.setBannerId(moocBannerT.getUuid()+"");
            bannerVO.setBannerAddress(moocBannerT.getBannerAddress());
            result.add(bannerVO);
        }



        return result;
    }
    private List<FilmInfo> getFilmInfos(List<MoocFilmT> moocFilms){
        List<FilmInfo> filmInfos = new ArrayList<>();
        for(MoocFilmT moocFilmT : moocFilms){
            FilmInfo filmInfo = new FilmInfo();
            filmInfo.setScore(moocFilmT.getFilmScore());
            filmInfo.setImgAddress(moocFilmT.getImgAddress());
            filmInfo.setFilmType(moocFilmT.getFilmType());
            filmInfo.setFilmScore(moocFilmT.getFilmScore());
            filmInfo.setFilmName(moocFilmT.getFilmName());
            filmInfo.setFilmId(moocFilmT.getUuid()+"");
            filmInfo.setExpectNum(moocFilmT.getFilmPresalenum());
            filmInfo.setBoxNum(moocFilmT.getFilmBoxOffice());
            filmInfo.setShowTime(DateUtil.getDay(moocFilmT.getFilmTime()));

            // 将转换的对象放入结果集
            filmInfos.add(filmInfo);
        }

        return filmInfos;
    }
    @Override
    public FilmVO getHotFilms(boolean isLimit, int nums) {
        FilmVO filmVO=new FilmVO();
        List<FilmInfo> filmInfos = new ArrayList<>();
        EntityWrapper<MoocFilmT> entityWrapper=new EntityWrapper<MoocFilmT>();
        entityWrapper.eq("film_status","1");
        if(isLimit){
            Page<MoocFilmT> page=new Page<MoocFilmT>(1,nums);
            List<MoocFilmT> moocFilmTS=moocFilmTMapper.selectPage(page,entityWrapper);
            filmInfos=getFilmInfos(moocFilmTS);
            filmVO.setFilmNum(filmInfos.size());
            filmVO.setFilmInfo(filmInfos);
        }
        else{

        }


        return filmVO;
    }

    @Override
    public FilmVO getSoonFilms(boolean isLimit, int nums) {
        FilmVO filmVO=new FilmVO();
        List<FilmInfo> filmInfos = new ArrayList<>();
        EntityWrapper<MoocFilmT> entityWrapper=new EntityWrapper<MoocFilmT>();
        entityWrapper.eq("film_status","2");
        if(isLimit){
            Page<MoocFilmT> page=new Page<MoocFilmT>(1,nums);
            List<MoocFilmT> moocFilmTS=moocFilmTMapper.selectPage(page,entityWrapper);
            filmInfos=getFilmInfos(moocFilmTS);
            filmVO.setFilmNum(filmInfos.size());
            filmVO.setFilmInfo(filmInfos);
        }
        else{

        }
        return filmVO;
    }

    @Override
    public List<FilmInfo> getBoxRanking() {
        // 条件 -> 正在上映的，票房前10名
        EntityWrapper<MoocFilmT> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("film_status","1");

        Page<MoocFilmT> page = new Page<>(1,10,"film_box_office");

        List<MoocFilmT> moocFilms = moocFilmTMapper.selectPage(page,entityWrapper);

        List<FilmInfo> filmInfos = getFilmInfos(moocFilms);
        return filmInfos;
    }

    @Override
    public List<FilmInfo> getExpectRanking() {
        // 条件 -> 即将上映的，预售前10名
        EntityWrapper<MoocFilmT> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("film_status","2");

        Page<MoocFilmT> page = new Page<>(1,10,"film_preSaleNum");

        List<MoocFilmT> moocFilms = moocFilmTMapper.selectPage(page,entityWrapper);

        List<FilmInfo> filmInfos = getFilmInfos(moocFilms);
        return filmInfos;
    }

    @Override
    public List<FilmInfo> getTop() {
        // 条件 -> 正在上映的，评分前10名
        EntityWrapper<MoocFilmT> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("film_status","1");

        Page<MoocFilmT> page = new Page<>(1,10,"film_score");

        List<MoocFilmT> moocFilms = moocFilmTMapper.selectPage(page,entityWrapper);

        List<FilmInfo> filmInfos = getFilmInfos(moocFilms);
        return filmInfos;
    }

    @Override
    public List<CatVO> getCats() {
        List<CatVO> cats = new ArrayList<>();
        // 查询实体对象 - MoocCatDictT
        List<MoocCatDictT> moocCats = moocCatDictTMapper.selectList(null);
        // 将实体对象转换为业务对象 - CatVO
        for(MoocCatDictT moocCatDictT : moocCats){
            CatVO catVO = new CatVO();
            catVO.setCatId(moocCatDictT.getUuid()+"");
            catVO.setCatName(moocCatDictT.getShowName());

            cats.add(catVO);
        }

        return cats;
    }

    @Override
    public List<SourceVO> getSources() {
        List<SourceVO> sources = new ArrayList<>();
        List<MoocSourceDictT> moocSourceDicts = moocSourceDictTMapper.selectList(null);
        for(MoocSourceDictT moocSourceDictT : moocSourceDicts){
            SourceVO sourceVO = new SourceVO();

            sourceVO.setSourceId(moocSourceDictT.getUuid()+"");
            sourceVO.setSourceName(moocSourceDictT.getShowName());

            sources.add(sourceVO);
        }
        return sources;
    }

    @Override
    public List<YearVO> getYears() {
        List<YearVO> years = new ArrayList<>();
        // 查询实体对象 - MoocCatDictT
        List<MoocYearDictT> moocYears = moocYearDictTMapper.selectList(null);
        // 将实体对象转换为业务对象 - CatVO
        for(MoocYearDictT moocYearDictT : moocYears){
            YearVO yearVO = new YearVO();
            yearVO.setYearId(moocYearDictT.getUuid()+"");
            yearVO.setYearName(moocYearDictT.getShowName());

            years.add(yearVO);
        }
        return years;
    }
}
