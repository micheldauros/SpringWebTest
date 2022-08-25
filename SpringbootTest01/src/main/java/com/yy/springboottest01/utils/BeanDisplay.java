package com.yy.springboottest01.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class BeanDisplay implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.toLowerCase(Locale.ROOT).contains("model"))
            System.out.println(beanName);
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
