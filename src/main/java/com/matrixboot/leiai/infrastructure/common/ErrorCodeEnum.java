package com.matrixboot.leiai.infrastructure.common;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>
 * create in 2021/10/24 12:07 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Getter
public enum ErrorCodeEnum {

    ALL_OK("00000", "一切 ok"),

    ARGUMENT_NULL("A0410", "请求必填参数为空");

    private String code;

    private String message;

    ErrorCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}