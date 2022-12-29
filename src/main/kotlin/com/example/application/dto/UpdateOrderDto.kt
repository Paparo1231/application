package com.example.application.dto

data class UpdateOrderDto(
    val id: Int,
    val personId: Int,
    val deliveryMethodId: Int?,
    val status: String
)
