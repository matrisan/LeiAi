package com.matrixboot.leiai.infrastructure.exception.handler;

import com.matrixboot.leiai.infrastructure.common.ErrorCodeEnum;
import com.matrixboot.leiai.infrastructure.common.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

/**
 * <p>
 * create in 2021/10/23 11:38 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Order(10)
@RestControllerAdvice
public class MethodArgumentNotValidExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public ResultVO<String> constraintViolationException(@NotNull ConstraintViolationException exception) {
        return ResultVO.failure(ErrorCodeEnum.ARGUMENT_NULL, exception.getConstraintViolations().iterator().next().getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResultVO<String> methodArgumentNotValidException(@NotNull MethodArgumentNotValidException exception) {
        return ResultVO.failure(ErrorCodeEnum.ARGUMENT_NULL, exception.getMessage());
    }

}
