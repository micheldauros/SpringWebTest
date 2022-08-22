package com.yy.miscellaneous.timer;


import org.aspectj.lang.annotation.Aspect;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Inherited
@Target(METHOD)
@Retention(RUNTIME)
public @interface TimerAspect {
}
