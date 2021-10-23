package com.matrixboot.leiai.infrastructure.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * <p>
 * create in 2021/10/22 7:39 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Aspect
@Component
public class AspectAccessLog {

    @Pointcut("execution(* com.matrixboot.leiai.application.service.*.*(..))")
    public void pointCut() {
    }

    /**
     * 环绕通知:手动引导代码执行
     *
     * @param pdj 可执行体
     * @return return
     * @throws Throwable Throwable
     */
    @Around(value = "pointCut()")
    public Object logAround(ProceedingJoinPoint pdj) throws Throwable {
        log.info("logAround...运行...参数列表是:{}", Arrays.asList(pdj.getArgs()));
        return pdj.proceed();
    }

}
