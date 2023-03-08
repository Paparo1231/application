package com.example.application.entities

import lombok.Data
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails


@Data
class SecurityPerson : UserDetails {
    private lateinit var username: String
    private lateinit var password: String
    private lateinit var authorities: MutableCollection<GrantedAuthority>
    val isActive: Boolean

    constructor(username: String, password: String, authorities: MutableCollection<GrantedAuthority>, isActive: Boolean) {
        this.username = username
        this.password = password
        this.authorities = authorities
        this.isActive = isActive
    }


    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return authorities
    }

    override fun getPassword(): String {
        return password
    }

    override fun getUsername(): String {
        return username
    }

    override fun isAccountNonExpired(): Boolean {
        return isActive
    }

    override fun isAccountNonLocked(): Boolean {
        return isActive
    }

    override fun isCredentialsNonExpired(): Boolean {
        return isActive
    }

    override fun isEnabled(): Boolean {
        return isActive
    }

    fun fromPerson(person: Person): UserDetails {
        return User(
            person.login, person.password, authorities
        )
    }
}
