package com.matrixboot.leiai.infrastructure.annotation;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * TODO
 * <p>
 * create in 2021/10/21 9:59 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
public class StatisticInterceptor implements MethodInterceptor, Serializable {

    @Override
    public Object invoke(@NotNull MethodInvocation invocation) throws Throwable {

        Object ret = invocation.proceed();

        return ret;
    }
}
