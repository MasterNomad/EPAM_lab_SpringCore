package org.shop.annotation;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class InjectRandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Random random = new Random();
        Arrays.stream(bean.getClass().getDeclaredFields()).forEach( field -> {
                    InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
                    if (Objects.nonNull(annotation)) {
                        int min = annotation.minValue();
                        int max = annotation.maxValue();
                        int randomInt = min + random.nextInt(max - min);
                        field.setAccessible(true);
                        ReflectionUtils.setField(field, bean, randomInt);
                    }
                }
            );
//        AtomicInteger streamRandomInt = new AtomicInteger();
//        Arrays.stream(bean.getClass().getDeclaredFields())
//                .map(f -> f.getAnnotation(InjectRandomInt.class))
//                .filter(Objects::nonNull)
//                .peek(a -> streamRandomInt.set(a.maxValue() + random.nextInt(a.maxValue() - a.minValue())))
//                .
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }
}
