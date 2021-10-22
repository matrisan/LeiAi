package com.matrixboot.leiai.interfaces.facade;

import com.matrixboot.leiai.application.service.PeriodicalService;
import com.matrixboot.leiai.domain.entity.PeriodicalEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * create in 2021/10/21 7:45 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@RestController
public class PeriodicalFacade {

    @Resource
    private PeriodicalService service;

    @GetMapping("periodical/{name}")
    List<PeriodicalEntity> findAll(@PathVariable String name) {
        return service.findAllByName(name);
    }

}
