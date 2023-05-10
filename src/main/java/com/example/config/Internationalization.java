package com.example.config;

import java.util.Locale;

import org.hibernate.validator.internal.util.logging.Messages;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class Internationalization implements WebMvcConfigurer {
   
   // to determine default locale of your application
   @Bean
   public LocaleResolver localeResolver() {
      SessionLocaleResolver slr = new SessionLocaleResolver();
      slr.setDefaultLocale(Locale.US);
      return slr;
   }
   
   // localeChangeInterceptor is used to change the new locale
   // based on the value of the language parameter added to a request
   @Bean
   public LocaleChangeInterceptor localeChangeInterceptor() {
      LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
      lci.setParamName("language");
      
      return lci;
   }
   
   // to add the localeChangeInterceptor into the application's registry interceptor
   @Override
   public void addInterceptors(InterceptorRegistry registry) {
      registry.addInterceptor(localeChangeInterceptor());
      
   }
   

}