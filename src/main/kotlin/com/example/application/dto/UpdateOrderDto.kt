package com.example.application.dto

import com.example.application.entities.OrderStatus

data class UpdateOrderDto(
    val id: Int,
    val personId: Int,
    val deliveryMethodId: Int?,
    val status: OrderStatus
)
