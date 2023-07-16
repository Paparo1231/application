package com.example.application.entities

import javax.persistence.*

@Entity
@Table(name = "order_table")
data class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,
    val personId: Int,
    val deliveryMethodId: Int?,
    val address: String?,
    @Enumerated(EnumType.STRING)
    val status: OrderStatus
)
