package com.matrixboot.leiai.domain.repository;

import com.matrixboot.leiai.application.PeriodicalDTO;

import java.util.List;

/**
 * TODO
 * <p>
 * create in 2021/10/24 5:01 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
public interface IPeriodicalRemoteRepository {

    List<PeriodicalDTO> findAllByName(String name);

}
