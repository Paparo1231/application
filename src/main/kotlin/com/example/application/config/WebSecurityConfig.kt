package com.example.application.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder


@Configuration
@EnableWebSecurity
class WebSecurityConfig() : WebSecurityConfigurerAdapter() {

    private lateinit var userDetailsService: UserDetailsService

    @Autowired
    constructor(@Qualifier("userDetailsServiceImpl") userDetailsService: UserDetailsService) : this() {
        this.userDetailsService = userDetailsService
    }


    override fun configure(http: HttpSecurity?) {
        http!!.antMatcher("/**")
            .authorizeRequests()
            .antMatchers("/main/index", "/main/choosing", "/registration_user", "/registration_vendor")
            .permitAll()
            .anyRequest().authenticated()
            .and().formLogin().permitAll().defaultSuccessUrl("/person/post_auth_menu")
            .usernameParameter("login")
            .passwordParameter("password")
            .and().logout().permitAll()
            .and().csrf().disable()

    }


    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth!!.authenticationProvider(daoAuthenticationProvider()).userDetailsService(userDetailsService)
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return NoOpPasswordEncoder.getInstance()
    }

    @Bean
    fun daoAuthenticationProvider(): DaoAuthenticationProvider {
        val daoAuthenticationProvider = DaoAuthenticationProvider()
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder())
        daoAuthenticationProvider.setUserDetailsService(userDetailsService())
        return daoAuthenticationProvider
    }
}
