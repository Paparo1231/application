package com.example.application.dto


import com.example.application.entities.Role

// сущность тела json-запроса
data class CreatePersonDto(
    var name: String?,
    var patronymic: String?,
    var surname: String?,
    var login: String?,
    var password: String?,
    var phone_number: String?,
    var role: Role?,
    var email: String?
)
