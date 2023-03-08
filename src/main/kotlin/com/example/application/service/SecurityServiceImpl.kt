package com.example.application.service

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class SecurityServiceImpl : SecurityService {


    private lateinit var authenticationManager: AuthenticationManager

    @Autowired
    private lateinit var userDetailsService: UserDetailsService

    override fun findLoggedInUserName(): String? {
        val userDetails = SecurityContextHolder.getContext().authentication.details

        if(userDetails is UserDetails) {
            return userDetails.username
        }
        return null
    }

    override fun autoLogin(username: String, password: String) {
        val userDetails  : UserDetails
                = userDetailsService.loadUserByUsername(username)

        val authenticationToken =
                    UsernamePasswordAuthenticationToken(userDetails, password, userDetails.authorities)

        authenticationManager.authenticate(authenticationToken)

        if(authenticationToken.isAuthenticated) {
            SecurityContextHolder.getContext().authentication = authenticationToken
            log.info("Авторизован успешно")
        }
    }


    companion object {
        private val log = LoggerFactory.getLogger(SecurityServiceImpl::class.java)
    }
}
