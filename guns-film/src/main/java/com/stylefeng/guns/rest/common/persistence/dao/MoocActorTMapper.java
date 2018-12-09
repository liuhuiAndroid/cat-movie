package com.stylefeng.guns.rest.common.persistence.dao;

import com.stylefeng.guns.api.film.vo.ActorVO;
import com.stylefeng.guns.rest.common.persistence.model.MoocActorT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 演员表 Mapper 接口
 * </p>
 *
 * @author liu
 * @since 2018-10-03
 */
public interface MoocActorTMapper extends BaseMapper<MoocActorT> {
    List<ActorVO> getActors(@Param("filmId") String filmId);
}
