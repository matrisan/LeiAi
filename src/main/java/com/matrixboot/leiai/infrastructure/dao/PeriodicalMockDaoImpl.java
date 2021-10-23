package com.matrixboot.leiai.infrastructure.dao;

import com.matrixboot.leiai.domain.entity.PeriodicalEntity;
import com.matrixboot.leiai.domain.repository.IPeriodicalRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

/**
 * <p>
 * create in 2021/10/21 7:44 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Primary
@Repository
public class PeriodicalMockDaoImpl implements IPeriodicalRepository {

    @Override
    public List<PeriodicalEntity> findAllByName(String name) {
        return Collections.emptyList();
    }
}
