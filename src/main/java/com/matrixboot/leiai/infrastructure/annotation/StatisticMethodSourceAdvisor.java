package com.matrixboot.leiai.infrastructure.annotation;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * TODO
 * <p>
 * create in 2021/10/21 11:03 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
public class StatisticMethodSourceAdvisor extends AbstractPointcutAdvisor implements BeanFactoryAware {

    @Override
    public Pointcut getPointcut() {
        return null;
    }

    @Override
    public Advice getAdvice() {
        return null;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

    }
}
