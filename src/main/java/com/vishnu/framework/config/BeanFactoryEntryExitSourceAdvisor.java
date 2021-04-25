package com.vishnu.framework.config;

import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractBeanFactoryPointcutAdvisor;
import org.springframework.cache.interceptor.CacheOperationSource;
import org.springframework.lang.Nullable;

public class BeanFactoryEntryExitSourceAdvisor  extends AbstractBeanFactoryPointcutAdvisor {

   private final EntryExitPointcut pointcut = new EntryExitPointcut();

    @Override
    public Pointcut getPointcut() {
        return this.pointcut;
    }
}
