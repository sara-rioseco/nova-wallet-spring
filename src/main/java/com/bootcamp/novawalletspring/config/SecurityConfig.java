package com.bootcamp.novawalletspring.config;

import com.bootcamp.novawalletspring.service.impl.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * The type Security config.
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {

    /**
     * Security Filter Chain.
     *
     * @param http the http
     * @return the security filter chain
     * @throws Exception the exception
     */
    @Bean
    public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception {

        String[] matchers = new String[] {"/login", "/signup", "/public/**","/api/**", "**.js", "**.css", "img/**.svg", "fonts/**", "**.ico"};
        return http
                .httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests(req ->
                        req.requestMatchers(matchers).permitAll())
                .authorizeHttpRequests(req ->
                        req.anyRequest().authenticated())
                .authorizeHttpRequests(req ->
                        req.anyRequest().hasAnyRole())
                .sessionManagement(session -> {
                    session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                            .maximumSessions(10)
                            .expiredUrl("/login");
                    session.invalidSessionUrl("/login");
                })
                .formLogin((form)->
                        form
                                .loginPage("/login")
                                .defaultSuccessUrl("/home", true)
                                .permitAll()
                )
                .logout(LogoutConfigurer::permitAll)
                .csrf(AbstractHttpConfigurer::disable)
                .build();
    }

    /**
     * Web security customizer.
     *
     * @return the web security customizer
     */
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/WEB-INF/jsp/**");
    }

    /**
     * Authentication manager.
     *
     * @param authConfig the auth config
     * @return the authentication manager
     * @throws Exception the exception
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    /**
     * Authentication provider.
     *
     * @param userDetailsService the user details service
     * @return the authentication provider
     */
    @Bean
    public AuthenticationProvider authProvider(UserDetailsServiceImpl userDetailsService){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }

    /**
     * Password Encoder.
     *
     * @return the password encoder
     */
    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
