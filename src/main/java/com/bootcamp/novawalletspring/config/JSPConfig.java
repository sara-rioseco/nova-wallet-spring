package com.bootcamp.novawalletspring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * The type Jsp config.
 */
@Configuration
public class JSPConfig {
    /**
     * Jsp view resolver internal resource view resolver.
     *
     * @return the internal resource view resolver
     */
    @Bean
    InternalResourceViewResolver jspViewResolver(){
        final InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setOrder(10);
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setViewNames("*.jsp");
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix("");
        return viewResolver;
    }
}
