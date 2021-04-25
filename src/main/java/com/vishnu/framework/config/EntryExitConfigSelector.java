package com.vishnu.framework.config;

import com.vishnu.framework.annotations.EnableEntryExists;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.AdviceModeImportSelector;
import org.springframework.context.annotation.AutoProxyRegistrar;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EntryExitConfigSelector extends AdviceModeImportSelector<EnableEntryExists> {

    @Override
    protected String[] selectImports(AdviceMode adviceMode) {
        return getProxyImports();
    }

    private String[] getProxyImports() {
        List<String> result = new ArrayList<>(3);
        result.add(AutoProxyRegistrar.class.getName());
        result.add(ProxyEntryExitConfiguration.class.getName());
        return StringUtils.toStringArray(result);
    }
}
