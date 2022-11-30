package com.codeup.springblog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.hibernate.criterion.Restrictions.and;

@Configuration
public class SecurityConfiguration {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers("/", "/post", "/posts/{id}").permitAll()
                .antMatchers("/post/create", "/posts/{id}/edit").authenticated()
                .and().formLogin()
                .and().httpBasic();
        return http.build();
    }
}
