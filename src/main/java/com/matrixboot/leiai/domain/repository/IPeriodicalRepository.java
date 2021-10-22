package com.matrixboot.leiai.domain.repository;

import com.matrixboot.leiai.domain.entity.PeriodicalEntity;

import java.util.List;

/**
 * TODO
 * <p>
 * create in 2021/10/21 4:28 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
public interface IPeriodicalRepository {

    List<PeriodicalEntity> findAllByName(String name);

}
