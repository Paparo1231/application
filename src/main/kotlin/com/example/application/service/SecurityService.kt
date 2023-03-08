package com.example.application.service


interface SecurityService {
    fun findLoggedInUserName() : String?

    fun autoLogin(username: String, password: String)
}
