package com.matrixboot.leiai.interfaces.facade;

import com.matrixboot.leiai.application.PeriodicalVO;
import com.matrixboot.leiai.application.service.PeriodicalService;
import com.matrixboot.leiai.domain.entity.PeriodicalEntity;
import com.matrixboot.leiai.interfaces.dto.ResultVO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * create in 2021/10/21 7:45 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@AllArgsConstructor
@RestController
public class PeriodicalFacade {

    private final PeriodicalService service;

    @GetMapping("periodical/{name}")
    ResultVO<List<PeriodicalEntity>> findAll(@PathVariable String name) {
        List<PeriodicalVO> list = service.findAllByName(name);
        return ResultVO.success();
    }

}
