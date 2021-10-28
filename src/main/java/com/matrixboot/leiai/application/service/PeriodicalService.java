package com.matrixboot.leiai.application.service;

import com.matrixboot.leiai.application.IPeriodicalVO;
import com.matrixboot.leiai.application.PeriodicalDTO;
import com.matrixboot.leiai.application.PeriodicalFactory;
import com.matrixboot.leiai.domain.repository.IPeriodicalRemoteRepository;
import com.matrixboot.leiai.domain.repository.IPeriodicalRepository;
import com.matrixboot.leiai.infrastructure.annotation.Statistic;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    private final IPeriodicalRemoteRepository remoteRepository;

    @Statistic("#name")
    public List<IPeriodicalVO> findAllByName(String name) {
        List<PeriodicalDTO> list = remoteRepository.findAllByName(name);
        list.forEach(this::peek);
        return list.stream().map(PeriodicalDTO::getRecId).map(this::map).collect(Collectors.toList());
    }

    private void peek(@NotNull PeriodicalDTO periodical) {
        if (!periodicalRepository.existsByRecId(periodical.getRecId())) {
            periodicalRepository.save(PeriodicalFactory.from(periodical));
        } else {
            periodicalRepository.updateGlimpseByRecId(periodical.getRecId());
        }
    }

    private IPeriodicalVO map(String id) {
        return periodicalRepository.findByRecId(id, IPeriodicalVO.class);
    }
}
