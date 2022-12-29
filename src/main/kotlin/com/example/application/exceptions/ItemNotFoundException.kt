package com.example.application.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class ItemNotFoundException(id: Int) :
    RuntimeException("Товар с id = $id не найден"){

}
