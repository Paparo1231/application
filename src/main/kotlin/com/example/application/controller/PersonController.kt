package com.example.application.controller

import com.example.application.entities.Person
import com.example.application.service.PersonService
import com.example.application.service.SavePersonRequest
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/person", produces =
[MediaType.APPLICATION_JSON_VALUE])
class PersonController(private val personService : PersonService) {
    @GetMapping
    fun findAll() = personService.findAll()

    @GetMapping("{id}")
    fun findById(@PathVariable("id") id: Int) : Person {
        return personService.findById(id)
    }

    @PostMapping
    fun create(@Valid @RequestBody request:
    SavePersonRequest) : ResponseStatus {
        personService.create(request)
        return ResponseStatus(HttpStatus.CREATED)
    }

    @PutMapping("{id}")
    fun update(
        @PathVariable("id") id: Int,
        @Valid @RequestBody request: SavePersonRequest
    ): ResponseStatus {
        personService.update(id, request)
        return ResponseStatus(HttpStatus.OK)
    }
}
