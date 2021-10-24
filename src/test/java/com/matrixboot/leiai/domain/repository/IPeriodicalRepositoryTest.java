package com.matrixboot.leiai.domain.repository;

import com.matrixboot.leiai.application.PeriodicalDTO;
import com.matrixboot.leiai.domain.entity.PeriodicalEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TODO
 * <p>
 * create in 2021/10/21 6:07 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@SpringBootTest
class IPeriodicalRepositoryTest {

    @Resource
    private IPeriodicalRemoteRepository repository;


    @Test
    void findAllByName() {
        List<PeriodicalDTO> list = repository.findAllByName("新浪");
        list.forEach(System.out::println);
    }
}