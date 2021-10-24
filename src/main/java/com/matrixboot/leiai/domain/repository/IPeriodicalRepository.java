package com.matrixboot.leiai.domain.repository;

import com.matrixboot.leiai.application.PeriodicalDTO;
import com.matrixboot.leiai.domain.entity.PeriodicalEntity;
import com.matrixboot.leiai.domain.entity.StatisticEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <p>
 * create in 2021/10/21 4:28 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
public interface IPeriodicalRepository extends JpaRepository<PeriodicalEntity, Long> {

    boolean existsByRecId(String recId);


    <T> T findByRecId(String recId, Class<T> clz);

}
