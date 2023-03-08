package com.example.application.config

import com.example.application.dao.PersonDao
import com.example.application.service.PersonService
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
@EnableWebSecurity
class WebSecurityConfig() : WebSecurityConfigurerAdapter() {

    @Autowired
    private lateinit var personService: PersonService

    @Autowired
    private lateinit var personDao: PersonDao

    private lateinit var userDetailsService: UserDetailsService

    @Autowired
    constructor(@Qualifier("userDetailsServiceImpl") userDetailsService: UserDetailsService) : this() {
        this.userDetailsService = userDetailsService
    }


    override fun configure(http: HttpSecurity?) {
        http!!.antMatcher("/**")
            .authorizeRequests()
            .antMatchers("/login**", "/main/**", "/**")
            .permitAll()
            .anyRequest().authenticated()
            .and().formLogin().permitAll()
            .usernameParameter("login")
            .passwordParameter("password")
            .and().logout().permitAll()
            .and().csrf().disable()

    }


    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth!!.authenticationProvider(daoAuthenticationProvider())
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder(12)
    }

    @Bean
    fun daoAuthenticationProvider(): DaoAuthenticationProvider {
        val daoAuthenticationProvider = DaoAuthenticationProvider()
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder())
        daoAuthenticationProvider.setUserDetailsService(userDetailsService())
        return daoAuthenticationProvider
    }
}
