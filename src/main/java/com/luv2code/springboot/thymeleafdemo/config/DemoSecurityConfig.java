package com.luv2code.springboot.thymeleafdemo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(@Qualifier("securityDataSource") DataSource dataSource) {

        return new JdbcUserDetailsManager(dataSource);
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer -> configurer
            .requestMatchers("/").authenticated()
            .requestMatchers("/employees/showForm/**").hasRole("EMPLOYEE")
            .requestMatchers("/employees/save").hasAnyRole("MANAGER", "ADMIN")
            .requestMatchers("/employees/delete").hasRole("ADMIN")
            .requestMatchers("/employees/**").hasRole("EMPLOYEE")
            .requestMatchers("/**").permitAll()
            .requestMatchers("/resources/**").permitAll()
        ).formLogin(form -> form.loginPage("/showMyLoginPage").loginProcessingUrl("/authenticateTheUser").permitAll()
        ).logout(logout -> logout.permitAll());
        return http.build();
    }

}
