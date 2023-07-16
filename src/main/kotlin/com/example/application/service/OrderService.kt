package com.example.application.service

import com.example.application.dto.CreateOrderDto
import com.example.application.entities.Order

interface OrderService {
    fun findById(id: Int) : Order?

    fun create(request: CreateOrderDto): Order

    fun update(id: Int, request: CreateOrderDto)

    fun delete(id: Int)

}
