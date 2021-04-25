package com.vishnu.framework.annotations;

import com.vishnu.framework.config.EntryExitConfigSelector;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Import;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Service;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(EntryExitConfigSelector.class)
public @interface EnableEntryExists {

    boolean proxyTargetClass() default false;

    AdviceMode mode() default AdviceMode.PROXY;

    int order() default Ordered.LOWEST_PRECEDENCE;

    Class<? extends Annotation>[] allowedAnnotations() default Service.class;

}
