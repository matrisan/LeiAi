package com.matrixboot.leiai.infrastructure.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * create in 2021/9/28 12:23 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResultVO<T> {

    private String code;

    private T data;

    private String message;

    public static <T> ResultVO<T> success() {
        return ResultVO.<T>builder().code(ErrorCodeEnum.ALL_OK.getCode()).build();
    }

    public static <T> ResultVO<T> success(T data) {
        return ResultVO.<T>builder().code(ErrorCodeEnum.ALL_OK.getCode()).data(data).build();
    }

    public static <T> ResultVO<T> success(ErrorCodeEnum errorCodeEnum) {
        return ResultVO.<T>builder().code(errorCodeEnum.getCode()).message(errorCodeEnum.getMessage()).build();
    }

    public static <T> ResultVO<T> failure() {
        return ResultVO.<T>builder().code(ErrorCodeEnum.INVALID_INPUT.getCode()).build();
    }

    public static <T> ResultVO<T> failure(String message) {
        return ResultVO.<T>builder().code(ErrorCodeEnum.ALL_OK.getCode()).message(message).build();
    }

    public static <T> ResultVO<T> failure(ErrorCodeEnum errorCodeEnum) {
        return ResultVO.<T>builder().code(errorCodeEnum.getCode()).message(errorCodeEnum.getMessage()).build();
    }

    public static <T> ResultVO<T> failure(ErrorCodeEnum errorCodeEnum, String message) {
        return ResultVO.<T>builder().code(errorCodeEnum.getCode()).message(errorCodeEnum.getMessage()).build();
    }
}
