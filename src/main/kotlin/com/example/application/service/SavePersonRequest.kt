package com.example.application.service


import java.time.LocalDate
import javax.validation.constraints.NotNull
import javax.validation.constraints.Past
import javax.validation.constraints.Size

// сущность тела json-запроса
data class SavePersonRequest(
    @get:NotNull
    @get:Size(min = 1, max = 50)
    val name: String?,

    @get:NotNull
    val patronymic: String?,

    @get:NotNull
    val surname: String?,

    @get:NotNull
    val login: String?,

    @get:NotNull
    val password: String?,

    @get:NotNull
    val phone_number: String?,

    @get:NotNull
    val status: String?,

    @get:NotNull
    val email: String?,

    @get: NotNull
    @get:Past
    val created: LocalDate?
)
