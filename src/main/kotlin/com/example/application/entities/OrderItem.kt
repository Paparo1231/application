package com.example.application.entities

import javax.persistence.*

@Entity
@Table(name = "order_item_table")
data class OrderItem(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Int? = null,
    val itemId: Int,
    val orderId: Int,
    val count: Int
)
