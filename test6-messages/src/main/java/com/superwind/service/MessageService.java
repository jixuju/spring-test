package com.superwind.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.apache.commons.lang.LocaleUtils;

import java.util.Locale;

@Service
public class MessageService {
    @Autowired
    @Qualifier("messageSource")
    protected MessageSource messageSource;

    public String getI18nMessage(String language, String msgKey, Object[] msgParams) {
        Locale locale = LocaleUtils.toLocale(language);
        return messageSource.getMessage(msgKey, msgParams, locale);
    }
}
