package com.matrixboot.leiai.domain.repository;

import com.matrixboot.leiai.domain.entity.StatisticEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TODO
 * <p>
 * create in 2021/10/21 4:14 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
public interface IStatisticRepository extends JpaRepository<StatisticEntity, Long> {
}
