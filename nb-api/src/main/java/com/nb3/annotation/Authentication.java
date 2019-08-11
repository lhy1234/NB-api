package com.nb3.annotation;

import java.lang.annotation.*;


/**
 * 是否需要登录
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Authentication {

    boolean value() default false;
}
