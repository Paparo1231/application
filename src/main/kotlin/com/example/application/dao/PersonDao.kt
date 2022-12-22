package com.example.application.dao

import com.example.application.entities.Person
import org.springframework.data.repository.CrudRepository

interface PersonDao : CrudRepository<Person, Int> {
    fun findByOrderByName(): List<Person>
}
