package com.vishnu.framework.config;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Objects;

public class EntryExitInterceptor implements MethodInterceptor, Serializable {

    private static Logger logger = LogManager.getLogger(EntryExitInterceptor.class.getName());

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Method method = invocation.getMethod();
        Object target = invocation.getThis();
        Annotation declaredAnnotations = target.getClass().getDeclaredAnnotation(Service.class);
        if(Objects.nonNull(declaredAnnotations)) {
            logger.info("Entered into Method {} :: {} :: {}", target.getClass().getName(), method.getName(), method.getParameters() );
        }
        Object obj = invocation.proceed();
        if(Objects.nonNull(declaredAnnotations)) {
            logger.info("Entered into Method {} :: {} :: {}", target.getClass().getName(),method.getName(),obj);
        }
        return obj;
    }
}
