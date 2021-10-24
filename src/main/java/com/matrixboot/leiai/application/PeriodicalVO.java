package com.matrixboot.leiai.application;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;

import java.util.function.Function;

/**
 * TODO
 * <p>
 * create in 2021/10/23 2:16 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PeriodicalVO {

    private String orgType;

    private String hostUnit;

    private String address;

    private String station;

    private String recId;

    private String orgName;

    private String chargeUnit;

    private String languate;

    private String orgCn;

    private String linkNum;

    PeriodicalVO map(Function<?, PeriodicalVO> converter) {
        return null;
    }

}
