package com.example.application.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class OrderNotFoundException(id: Int) :
    RuntimeException("Заказ с идентификатором $id не найден"){}
