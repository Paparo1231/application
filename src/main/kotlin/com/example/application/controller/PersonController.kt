package com.example.application.controller

import com.example.application.dto.CreatePersonDto
import com.example.application.entities.Person
import com.example.application.service.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView
import javax.validation.Valid


@RestController
@RequestMapping(
    "/person", produces =
    [MediaType.APPLICATION_JSON_VALUE]
)
class PersonController {

    @Autowired
    private lateinit var personService: PersonService


    @GetMapping
    fun findAll() = personService.findAll()

    @GetMapping("{id}")
    fun findById(@PathVariable("id") id: Int): Person {
        return personService.findById(id)
    }

    @GetMapping("/info")
    fun personInfo(model: Model) : ModelAndView{
        val auth = SecurityContextHolder.getContext().authentication
        val person: Person = auth.principal as Person

        model.addAttribute("username", person.login)
        model.addAttribute("email", person.email)
        model.addAttribute("phoneNumber", person.phone_number)
        model.addAttribute("role", person.status)
        model.addAttribute("id", "test Id")

        return ModelAndView("show_person")
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(
        @Valid request: CreatePersonDto
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
