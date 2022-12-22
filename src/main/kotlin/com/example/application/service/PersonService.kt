package com.example.application.service

import com.example.application.entities.Person

interface PersonService {
    fun findAll() : List<Person>

    fun findById(id: Int) : Person

    fun create(request: SavePersonRequest)

    fun update(id: Int, request: SavePersonRequest)

    fun delete(id: Int)
}
