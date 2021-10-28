package com.matrixboot.leiai.domain.repository;

import com.matrixboot.leiai.domain.entity.PeriodicalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

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

    @Modifying
    @Transactional(rollbackFor = Exception.class)
    @Query("UPDATE PeriodicalEntity AS periodical SET periodical.glimpse = (periodical.glimpse + 1) WHERE periodical.recId = ?1")
    void updateGlimpseByRecId(String recId);

}
