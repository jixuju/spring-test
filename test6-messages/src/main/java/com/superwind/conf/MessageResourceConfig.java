package com.superwind.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class MessageResourceConfig {
    private static final String I18N_RESOURCE = "classpath:com/superwind/i18n/Messages";

    @Bean(name = "messageSource")
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        String[] resources = {I18N_RESOURCE};
        messageSource.setBasenames(resources);
        messageSource.setCacheSeconds(60);
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
