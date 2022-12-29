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
    //@Enumerated(EnumType.STRING) создай енам епта
    val status: String
)
