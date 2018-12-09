package com.stylefeng.guns.rest.modular.film.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.api.film.FilmAsyncServiceApi;
import com.stylefeng.guns.api.film.vo.ActorVO;
import com.stylefeng.guns.api.film.vo.FilmDescVO;
import com.stylefeng.guns.api.film.vo.ImgVO;
import com.stylefeng.guns.rest.common.persistence.dao.MoocActorTMapper;
import com.stylefeng.guns.rest.common.persistence.dao.MoocFilmInfoTMapper;
import com.stylefeng.guns.rest.common.persistence.model.MoocActorT;
import com.stylefeng.guns.rest.common.persistence.model.MoocFilmInfoT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 异步
 */
@Component
@Service(interfaceClass = FilmAsyncServiceApi.class)
public class DefaultFilmAsyncServiceImpl implements FilmAsyncServiceApi {

    @Autowired
    MoocFilmInfoTMapper moocFilmInfoTMapper;
    @Autowired
    MoocActorTMapper moocActorTMapper;

    /**
     * 根据影片ID获取影片详细信息
     *
     * @param filmId
     * @return
     */
    private MoocFilmInfoT getFilmInfo(String filmId) {
        MoocFilmInfoT moocFilmInfoT = new MoocFilmInfoT();
        moocFilmInfoT.setFilmId(filmId);
        moocFilmInfoT = moocFilmInfoTMapper.selectOne(moocFilmInfoT);
        return moocFilmInfoT;
    }

    /**
     * 获取影片描述信息
     *
     * @param filmId
     * @return
     */
    @Override
    public FilmDescVO getFilmDesc(String filmId) {
        MoocFilmInfoT moocFilmInfoT = getFilmInfo(filmId);
        FilmDescVO filmDescVO = new FilmDescVO();
        filmDescVO.setBiography(moocFilmInfoT.getBiography());
        filmDescVO.setFilmId(filmId);
        return filmDescVO;
    }

    /**
     * 获取图片信息
     *
     * @param filmId
     * @return
     */
    @Override
    public ImgVO getImgs(String filmId) {
        MoocFilmInfoT moocFilmInfoT = getFilmInfo(filmId);
        // 图片地址是五个以逗号为分隔的链接URL
        String filmImgStr = moocFilmInfoT.getFilmImgs();
        String[] filmImgs = filmImgStr.split(",");
        ImgVO imgVO = new ImgVO();
        if (filmImgs.length >= 5) {
            imgVO.setMainImg(filmImgs[0]);
            imgVO.setImg01(filmImgs[1]);
            imgVO.setImg02(filmImgs[2]);
            imgVO.setImg03(filmImgs[3]);
            imgVO.setImg04(filmImgs[4]);
        }
        return imgVO;
    }

    /**
     * 获取导演信息
     *
     * @param filmId
     * @return
     */
    @Override
    public ActorVO getDectInfo(String filmId) {
        MoocFilmInfoT moocFilmInfoT = getFilmInfo(filmId);
        // 获取导演编号
        Integer directId = moocFilmInfoT.getDirectorId();
        MoocActorT moocActorT = moocActorTMapper.selectById(directId);
        ActorVO actorVO = new ActorVO();
        actorVO.setImgAddress(moocActorT.getActorImg());
        actorVO.setDirectorName(moocActorT.getActorName());
        return actorVO;
    }

    /**
     * 获取演员信息
     *
     * @param filmId
     * @return
     */
    @Override
    public List<ActorVO> getActors(String filmId) {
        List<ActorVO> actors = moocActorTMapper.getActors(filmId);
        return actors;
    }

}
