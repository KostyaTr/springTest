package com.github.KostyaTr.springTest.custom.processor;

import com.github.KostyaTr.springTest.custom.annotation.Profiling;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.util.HashMap;
import java.util.Map;


public class ProfilingProcessor implements BeanPostProcessor {
    private final Map<String,Long> startTime = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        ReflectionUtils.doWithMethods(bean.getClass(), method -> {
            if (method.getAnnotation(Profiling.class) != null){
                this.startTime.putIfAbsent(method.getName(), System.currentTimeMillis());
            }
        });
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        ReflectionUtils.doWithMethods(bean.getClass(), method -> {
            if (method.getAnnotation(Profiling.class) != null){
                System.out.println(method.getName() + " time spent: "
                        + (System.currentTimeMillis() - this.startTime.get(method.getName())));
            }
        });
        return bean;
    }
}
