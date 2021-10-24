package com.matrixboot.leiai.application;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * <p>
 * create in 2021/10/24 4:38 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Data
public class PeriodicalDTO {

    @JsonProperty("orgType")
    private String orgType;

    @JsonProperty("hostunit")
    private String hostUnit;

    @JsonProperty("address")
    private String address;

    @JsonProperty("station")
    private String station;

    @JsonProperty("recid")
    private String recId;

    @JsonProperty("orgname")
    private String orgName;

    @JsonProperty("chargeunit")
    private String chargeUnit;

    @JsonProperty("languate")
    private String language;

    @JsonProperty("orgcn")
    private String orgCn;

    @JsonProperty("linkNum")
    private String linkNum;

}
