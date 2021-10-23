package com.matrixboot.leiai.interfaces.facade;

import com.matrixboot.leiai.infrastructure.common.ErrorCodeEnum;
import com.matrixboot.leiai.infrastructure.common.ResultVO;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import javax.annotation.Resource;

/**
 * <p>
 * create in 2021/10/23 10:48 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ComplaintFacadeTest {

    @Resource
    private TestRestTemplate restTemplate;

    private final ParameterizedTypeReference<ResultVO<String>> myBean = new ParameterizedTypeReference<>() {
    };

    @Test
    @DisplayName("新增投诉")
    void complaint() {
        RequestEntity<String> requestEntity = RequestEntity.post("/complaint/new")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(getFullBody());
        ResponseEntity<ResultVO<String>> response = restTemplate.exchange(requestEntity, myBean);
        Assertions.assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue());
        ResultVO<String> body = response.getBody();
        Assertions.assertNotNull(body);
        Assertions.assertEquals("创建成功", body.getData());
    }


    @Nested
    @DisplayName("异常情况")
    class ErrorCode {

        @Test
        @DisplayName("异常情况-未传 type 返回 400")
        void noType() {
            RequestEntity<String> requestEntity = RequestEntity.post("/complaint/new")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .body(getNoTypeBody());
            ResponseEntity<ResultVO<String>> response = restTemplate.exchange(requestEntity, myBean);
            Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatusCodeValue());
            ResultVO<String> body = response.getBody();
            Assertions.assertNotNull(body);
            Assertions.assertEquals(ErrorCodeEnum.ARGUMENT_NULL.getCode(), body.getCode());
        }

        @Test
        @DisplayName("异常情况-未传 value 返回 400")
        void noValue() {
            RequestEntity<String> requestEntity = RequestEntity.post("/complaint/new")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .body(getValueBody());
            ResponseEntity<ResultVO<String>> response = restTemplate.exchange(requestEntity, myBean);
            Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatusCodeValue());
            ResultVO<String> body = response.getBody();
            Assertions.assertNotNull(body);
            Assertions.assertEquals(ErrorCodeEnum.ARGUMENT_NULL.getCode(), body.getCode());
        }

    }


    @NotNull
    @Contract(pure = true)
    private String getFullBody() {
        return "{\"type\": \"QQ\",\"value\": \"123456\"}";
    }


    @NotNull
    @Contract(pure = true)
    private String getNoTypeBody() {
        return "{\"value\": \"123456\"}";
    }

    @NotNull
    @Contract(pure = true)
    private String getValueBody() {
        return "{\"type\": \"QQ\"}";
    }

}