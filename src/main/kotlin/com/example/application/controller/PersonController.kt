package com.example.application.controller

import com.example.application.dto.CreatePersonDto
import com.example.application.entities.Person
import com.example.application.entities.RoleStatus
import com.example.application.service.PersonService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView
import javax.validation.Valid


@RestController
@RequestMapping(
    "/person", produces =
    [MediaType.APPLICATION_JSON_VALUE]
)
class PersonController(private val personService: PersonService) {
    @GetMapping
    fun findAll() = personService.findAll()

    @GetMapping("/new")
    fun createUserPage(@ModelAttribute("person") person: Person, model: Model): ModelAndView {
        return ModelAndView("new")
    }

    @PostMapping("/new")
    fun createNewUser(@ModelAttribute("person") person: Person, model: Model, createPersonDto: CreatePersonDto) : ModelAndView{
        createPersonDto.name = person.name
        createPersonDto.patronymic = person.patronymic
        createPersonDto.surname = person.surname
        createPersonDto.login = person.login
        createPersonDto.password = person.password
        createPersonDto.phone_number = person.phone_number
        createPersonDto.email = person.email
        createPersonDto.status = RoleStatus.USER

        create(createPersonDto)

        person.status = RoleStatus.USER
        return ModelAndView("person")
    }


    @GetMapping("{id}")
    fun findById(@PathVariable("id") id: Int): Person {
        return personService.findById(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(
        @Valid @RequestBody request: CreatePersonDto
    ) = personService.create(request)

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    fun update(
        @PathVariable("id") id: Int,
        @Valid @RequestBody request: CreatePersonDto
    ) {
        personService.update(id, request)
    }

    @DeleteMapping("{id}")
    fun deletePerson(@PathVariable("id") id: Int) = personService.delete(id)
}
