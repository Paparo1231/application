package com.example.application.service

import com.example.application.dto.CreatePersonDto
import com.example.application.entities.Person

interface PersonService {
    fun findAll() : List<Person>

    fun findById(id: Int) : Person

    fun create(request: CreatePersonDto): Person

    fun update(id: Int, request: CreatePersonDto)

    fun delete(id: Int)
}
