package com.bootcamp.novawalletspring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {
    @Bean
    SecurityFilterChain securityFilter(HttpSecurity http) throws Exception {

        String[] matchers = new String[] {"/public/**","/api/**", "**.ico", "**.css", "**.js", "**.woff2", "**.svg"};
        return http
                .authorizeHttpRequests(request ->
                        request.requestMatchers(matchers).permitAll())
                .authorizeHttpRequests(request ->
                        request.anyRequest().authenticated())
                .sessionManagement(sessionManagement -> {
                    sessionManagement.sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                            .maximumSessions(10)
                            .expiredUrl("/login");
                    sessionManagement.invalidSessionUrl("/login");
                })
                .formLogin((form)->
                        form
                                .loginPage("/login")
                                .defaultSuccessUrl("/home")
                                .permitAll()
                )
                .logout(logout-> logout.permitAll())
                .csrf(csrf-> csrf.disable())
                .build();
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/WEB-INF/jsp/**");
    }
}
