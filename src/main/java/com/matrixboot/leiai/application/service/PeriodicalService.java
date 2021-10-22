package com.matrixboot.leiai.application.service;

import com.matrixboot.leiai.domain.entity.PeriodicalEntity;
import com.matrixboot.leiai.domain.repository.IPeriodicalRepository;
import com.matrixboot.leiai.infrastructure.annotation.Statistic;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * create in 2021/10/21 8:16 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Service
public class PeriodicalService {

    @Resource
    private IPeriodicalRepository repository;

    @Statistic("#name")
    public List<PeriodicalEntity> findAllByName(String name) {
        return repository.findAllByName(name);
    }

}
