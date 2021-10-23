package com.matrixboot.leiai.domain.value;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * TODO
 * <p>
 * create in 2021/10/23 2:45 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
public class PeriodicalValue {

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
    private String linkNum;

}
