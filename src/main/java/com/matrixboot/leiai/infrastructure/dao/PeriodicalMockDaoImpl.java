package com.matrixboot.leiai.infrastructure.dao;

import com.matrixboot.leiai.application.PeriodicalDTO;
import com.matrixboot.leiai.domain.repository.IPeriodicalRemoteRepository;
import org.springframework.context.annotation.Primary;

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
//@Repository
public class PeriodicalMockDaoImpl implements IPeriodicalRemoteRepository {

    @Override
    public List<PeriodicalDTO> findAllByName(String name) {
        return Collections.emptyList();
    }
}
