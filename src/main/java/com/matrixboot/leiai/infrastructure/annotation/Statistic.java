package com.matrixboot.leiai.infrastructure.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 统计功能注解
 *
 * <p>
 * create in 2021/10/21 7:27 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Statistic {

    String value() default "";

}
