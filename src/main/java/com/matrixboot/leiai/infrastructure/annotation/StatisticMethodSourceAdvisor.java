package com.matrixboot.leiai.infrastructure.annotation;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.aop.Advice;
import org.jetbrains.annotations.NotNull;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.log.LogMessage;
import org.springframework.util.ClassUtils;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * <p>
 * create in 2021/10/21 11:03 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
public class StatisticMethodSourceAdvisor extends AbstractPointcutAdvisor implements BeanFactoryAware {

    private BeanFactory beanFactory;

    @Override
    public Pointcut getPointcut() {
        return new MethodSecurityMetadataSourcePointcut();
    }


    @Override
    public Advice getAdvice() {
        return beanFactory.getBean(StatisticInterceptor.class);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    static class MethodSecurityMetadataSourcePointcut extends StaticMethodMatcherPointcut implements Serializable {

        @Override
        public boolean matches(Method m, @NotNull Class<?> targetClass) {
            return !Objects.isNull(findAnnotation(m, targetClass, Statistic.class));
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

}
