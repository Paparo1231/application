package com.example.application.dto

data class CreateOrderDto(
    val personId: Int,
    val deliveryMethodId: Int?
)
