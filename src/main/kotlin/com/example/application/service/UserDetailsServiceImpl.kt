package com.example.application.service

import com.example.application.dao.PersonDao
import com.example.application.entities.Person
import com.example.application.entities.Role
import com.example.application.entities.SecurityPerson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service("userDetailsServiceImpl")
class UserDetailsServiceImpl : UserDetailsService {
    val personDao: PersonDao
    private lateinit var securityPerson : SecurityPerson

    @Autowired
    constructor(personDao: PersonDao) {
        this.personDao = personDao
    }


    @Transactional(readOnly = true)
    override fun loadUserByUsername(username: String?): UserDetails {
        val person: Person =
            personDao.findByLogin(username)

        val grantedAuthorities: HashSet<GrantedAuthority> = hashSetOf(
            SimpleGrantedAuthority(Role.USER.toString()),
            SimpleGrantedAuthority(Role.VENDOR.toString()),
            SimpleGrantedAuthority(Role.ADMIN.toString())
        )

        return securityPerson.fromPerson(person)
    }

}
