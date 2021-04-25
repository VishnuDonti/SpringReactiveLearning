package com.vishnu.framework.config;

import com.vishnu.framework.annotations.EnableEntryExists;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportAware;
import org.springframework.context.annotation.Role;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.lang.Nullable;

@Configuration(proxyBeanMethods = false)
@Role(BeanDefinition.ROLE_INFRASTRUCTURE)
public class ProxyEntryExitConfiguration implements ImportAware {

    @Nullable
    protected AnnotationAttributes enableEntryExits;

    @Bean
    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    public BeanFactoryEntryExitSourceAdvisor entryExitSourceAdvisor(EntryExitInterceptor entryExitInterceptor) {
        BeanFactoryEntryExitSourceAdvisor advisor = new BeanFactoryEntryExitSourceAdvisor();
        advisor.setAdvice(entryExitInterceptor);
        advisor.setOrder(this.enableEntryExits.getNumber("order"));
        return advisor;
    }

    @Bean
    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    public EntryExitInterceptor entryExitInterceptor() {
       return new EntryExitInterceptor();
    }

    @Override
    public void setImportMetadata(AnnotationMetadata importMetadata) {
        this.enableEntryExits = AnnotationAttributes.fromMap(
                importMetadata.getAnnotationAttributes(EnableEntryExists.class.getName(), false));
    }
}
