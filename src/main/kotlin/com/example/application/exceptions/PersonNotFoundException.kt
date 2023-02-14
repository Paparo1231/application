package com.example.application.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus


//исключение на статус 404
@ResponseStatus(HttpStatus.NOT_FOUND)
class PersonNotFoundException(id: Int) :
    RuntimeException("Человек с id = $id не найден")
