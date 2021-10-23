package com.matrixboot.leiai.application.service;

import com.matrixboot.leiai.application.PeriodicalVO;
import com.matrixboot.leiai.domain.entity.PeriodicalEntity;
import com.matrixboot.leiai.domain.repository.IPeriodicalRepository;
import com.matrixboot.leiai.infrastructure.annotation.Statistic;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * create in 2021/10/21 8:16 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@AllArgsConstructor
@Service
public class PeriodicalService {

    private final IPeriodicalRepository periodicalRepository;

    @Statistic("#name")
    public List<PeriodicalVO> findAllByName(String name) {
        List<PeriodicalEntity> list = periodicalRepository.findAllByName(name);



        return List.of();
    }

}
