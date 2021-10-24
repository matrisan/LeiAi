package com.matrixboot.leiai.application;

import com.matrixboot.leiai.domain.entity.PeriodicalEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * TODO
 * <p>
 * create in 2021/10/24 4:55 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PeriodicalFactory {

    public static PeriodicalEntity from(PeriodicalDTO periodical) {
        return PeriodicalEntity.builder()
                .orgType(periodical.getOrgType())
                .hostUnit(periodical.getHostUnit())
                .address(periodical.getAddress())
                .station(periodical.getStation())
                .recId(periodical.getRecId())
                .orgName(periodical.getOrgName())
                .chargeUnit(periodical.getChargeUnit())
                .language(periodical.getLanguate())
                .orgCn(periodical.getOrgCn())
                .linkNum(periodical.getLinkNum())
                .build();
    }

}
