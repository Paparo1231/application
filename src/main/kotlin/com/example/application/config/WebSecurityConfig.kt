package com.example.application.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
@EnableWebSecurity
public class WebSecurityConfig : WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity?) {
        http!!.antMatcher("/**")
            .authorizeRequests()
            .antMatchers("/", "/login**", "/js/**", "/error**", "/person/**", "/items/**", "/main/**", "/**")
            .permitAll()
            .anyRequest().authenticated()
            .and().formLogin().permitAll()
            .usernameParameter("login")
            .passwordParameter("password")
            .and().logout().permitAll()
            .and().csrf().disable()

    }
}
