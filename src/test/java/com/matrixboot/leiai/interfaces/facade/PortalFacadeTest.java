package com.matrixboot.leiai.interfaces.facade;

import com.matrixboot.leiai.interfaces.dto.ResultVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import javax.annotation.Resource;

/**
 * TODO
 * <p>
 * create in 2021/10/23 2:49 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@SpringBootTest
class PortalFacadeTest {

    @Resource
    private TestRestTemplate restTemplate;

    private final ParameterizedTypeReference<ResultVO<Long>> myBean = new ParameterizedTypeReference<>() {
    };

    @Test
    void userCount() {
        RequestEntity<Void> requestEntity = RequestEntity.get("/portal/user/count").build();
        ResponseEntity<ResultVO<Long>> response = restTemplate.exchange(requestEntity, myBean);
        ResultVO<Long> body = response.getBody();
        Assertions.assertNotNull(body);
        Assertions.assertEquals(0L, body.getData());
    }
}