package com.example.application.controller

import com.example.application.dto.CreatePersonDto
import com.example.application.entities.Person
import com.example.application.entities.Role
import com.example.application.service.PersonService
import com.example.application.service.SecurityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView

@RestController
@RequestMapping("/registration_user")
class RegistrationUserController {
    @Autowired
    private lateinit var personService: PersonService

    @Autowired
    private lateinit var securityService: SecurityService

    @GetMapping
    fun createUserPage(@ModelAttribute("person") person: Person): ModelAndView {
        return ModelAndView("new_user")
    }

    @PostMapping
    fun createNewUser(@ModelAttribute("person") person: String,
                      @ModelAttribute("name") name: String,
                      @ModelAttribute("patronymic") patronymic: String,
                      @ModelAttribute("surname") surname: String,
                      @ModelAttribute("login") login: String,
                      @ModelAttribute("password") password: String,
                      @ModelAttribute("phone_number") phone_number: String,
                      @ModelAttribute("email") email: String,
                      createPersonDto: CreatePersonDto
    ) : ModelAndView{

        createPersonDto.name = name
        createPersonDto.patronymic = patronymic
        createPersonDto.surname = surname
        createPersonDto.login = login
        createPersonDto.password = password
        createPersonDto.phone_number = phone_number
        createPersonDto.email = email
        createPersonDto.role = Role.USER

        personService.create(createPersonDto)

        securityService.autoLogin(login, password)

        return ModelAndView("creation_user_success")
    }
}
