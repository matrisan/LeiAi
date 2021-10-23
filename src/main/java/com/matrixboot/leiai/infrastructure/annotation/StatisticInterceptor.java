package com.matrixboot.leiai.infrastructure.annotation;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.jetbrains.annotations.NotNull;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.util.ClassUtils;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * TODO
 * <p>
 * create in 2021/10/21 9:59 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
public class StatisticInterceptor implements MethodInterceptor, Serializable {


    private ExpressionParser expressionParser = new SpelExpressionParser();

    @Override
    public Object invoke(@NotNull MethodInvocation invocation) throws Throwable {
        Object target = invocation.getThis();
        Class<?> targetClass = null;
        if (target != null) {
            targetClass = (target instanceof Class<?>) ? (Class<?>) target : AopProxyUtils.ultimateTargetClass(target);
        }
        Statistic annotation = findAnnotation(invocation.getMethod(), targetClass, Statistic.class);

        String value = annotation.value();
        Expression preAuthorizeExpression = expressionParser.parseExpression(value);




        Object ret = invocation.proceed();
        return ret;
    }

    private <A extends Annotation> A findAnnotation(Method method, Class<?> targetClass, Class<A> annotationClass) {
        // The method may be on an interface, but we need attributes from the target
        // class.
        // If the target class is null, the method will be unchanged.
        Method specificMethod = ClassUtils.getMostSpecificMethod(method, targetClass);
        A annotation = AnnotationUtils.findAnnotation(specificMethod, annotationClass);
        if (annotation != null) {
            log.debug("{} found on specific method: {}", annotation, specificMethod);
            return annotation;
        }
        // Check the original (e.g. interface) method
        if (specificMethod != method) {
            annotation = AnnotationUtils.findAnnotation(method, annotationClass);
            if (annotation != null) {
                log.debug("{} found on: {}", annotation, method);
                return annotation;
            }
        }
        // Check the class-level (note declaringClass, not targetClass, which may not
        // actually implement the method)
        annotation = AnnotationUtils.findAnnotation(specificMethod.getDeclaringClass(), annotationClass);
        if (annotation != null) {
            log.debug("{} found on: {}", annotation, specificMethod.getDeclaringClass().getName());
            return annotation;
        }
        return null;
    }

}
