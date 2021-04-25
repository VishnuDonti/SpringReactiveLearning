package com.vishnu.framework.config;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.CacheOperationSource;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Objects;

public class EntryExitPointcut extends StaticMethodMatcherPointcut implements Serializable {

    public EntryExitPointcut() {
        setClassFilter(new EntryExitClassFilter());
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        Method declaredMethods = null;
        try {
            declaredMethods = targetClass.getDeclaredMethod(method.getName(), method.getParameterTypes());
        } catch (Exception e) {
            // ignore
        }
        if (Objects.isNull(declaredMethods)) {
            return false;
        }
        if ((Modifier.isAbstract(method.getModifiers()) || Modifier.isPublic(method.getModifiers()))) {
            return true;
        }
        return false;
    }

    private class EntryExitClassFilter implements ClassFilter {

        @Override
        public boolean matches(Class<?> clazz) {
            Service[] declaredAnnotationsByType = clazz.getDeclaredAnnotationsByType(Service.class);
            if (declaredAnnotationsByType.length == 0) {
                return false;
            }
            return true;
        }
    }
}
