package com.matrixboot.leiai.interfaces.facade;

import com.matrixboot.leiai.application.IPeriodicalVO;
import com.matrixboot.leiai.application.service.PeriodicalService;
import com.matrixboot.leiai.infrastructure.common.ResultVO;
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

//    @GetMapping("/periodical/{name}")
    public ResultVO<List<IPeriodicalVO>> findAll(@PathVariable String name) {
        return ResultVO.success(service.findAllByName(name));
    }

    @GetMapping("/periodical/{name}")
    public String get(@PathVariable String name) {
        return "{\n" +
                "    \"code\": \"00000\",\n" +
                "    \"result\": [\n" +
                "        {\n" +
                "            \"address\": null,\n" +
                "            \"language\": \"未知语言\",\n" +
                "            \"recId\": \"6687B54660000441EA80D2D13B0D3F72\",\n" +
                "            \"orgType\": \"期刊\",\n" +
                "            \"hostUnit\": \"山东商报社\",\n" +
                "            \"station\": \"0\",\n" +
                "            \"orgName\": \"新浪潮\",\n" +
                "            \"chargeUnit\": \"山东省商业集团总公司\",\n" +
                "            \"orgCn\": \"37-1126/G0\",\n" +
                "            \"linkNum\": null,\n" +
                "            \"glimpse\": 0\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": null,\n" +
                "            \"language\": \"未知语言\",\n" +
                "            \"recId\": \"xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\",\n" +
                "            \"orgType\": \"期刊\",\n" +
                "            \"hostUnit\": \"山东商报社\",\n" +
                "            \"station\": \"0\",\n" +
                "            \"orgName\": \"新浪\",\n" +
                "            \"chargeUnit\": \"江苏省商业集团总公司\",\n" +
                "            \"orgCn\": \"12-1126/G0\",\n" +
                "            \"linkNum\": null,\n" +
                "            \"glimpse\": 0\n" +
                "        }\n" +
                "    ],\n" +
                "    \"message\": null\n" +
                "}";
    }

}
