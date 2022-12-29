package com.example.application.controller

import com.example.application.dto.CreateOrderDto
import com.example.application.dto.UpdateOrderDto
import com.example.application.service.OrderServiceImpl
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/orders", produces = [MediaType.APPLICATION_JSON_VALUE])
class OrderController(private val orderServiceImpl: OrderServiceImpl) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@Valid @RequestBody dto: CreateOrderDto
    ) = orderServiceImpl.createOrder(dto)

    @PutMapping("/changeStatus")
    fun changeOrderStatus(@RequestBody dto: UpdateOrderDto) = orderServiceImpl
        .changeOrderStatus(dto.id, dto.status)
}
