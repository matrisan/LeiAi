package com.matrixboot.leiai.infrastructure.annotation;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Role;

/**
 * TODO
 * <p>
 * create in 2021/10/21 10:07 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Configuration
public class StatisticConfig {


    @Bean
    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    StatisticMethodSourceAdvisor statisticMethodSourceAdvisor() {
        return new StatisticMethodSourceAdvisor();
    }

    @Bean
    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    StatisticInterceptor statisticInterceptor() {
        return new StatisticInterceptor();
    }

}
