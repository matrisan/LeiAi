package com.matrixboot.leiai.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * create in 2021/10/21 4:31 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Data
@NoArgsConstructor
public class PeriodicalEntity {

    @JsonProperty("orgType")
    private String orgType;
    @JsonProperty("hostunit")
    private String hostunit;
    @JsonProperty("address")
    private Object address;
    @JsonProperty("station")
    private String station;
    @JsonProperty("recid")
    private String recid;
    @JsonProperty("orgname")
    private String orgname;
    @JsonProperty("chargeunit")
    private String chargeunit;
    @JsonProperty("languate")
    private String languate;
    @JsonProperty("orgcn")
    private String orgcn;
    @JsonProperty("linkNum")
    private Object linkNum;
}
