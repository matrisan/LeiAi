package com.matrixboot.leiai.infrastructure.annotation;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.expression.BeanResolver;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * <p>
 * create in 2021/10/22 8:04 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
public class StatisticExpressionHandler implements ApplicationContextAware {

    private BeanResolver beanResolver;



    public final EvaluationContext createEvaluationContext() {
        StandardEvaluationContext ctx = createEvaluationContextInternal();
        ctx.setBeanResolver(this.beanResolver);
        return ctx;
    }


    protected StandardEvaluationContext createEvaluationContextInternal() {
        return new StandardEvaluationContext();
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.beanResolver = new BeanFactoryResolver(applicationContext);
    }
}
