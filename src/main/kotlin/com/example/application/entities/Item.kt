package com.example.application.entities

import javax.persistence.*


@Entity
@Table(name = "item_table")
data class Item(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Int? = null,

    @Column
    val itemName : String?,

    @Column
    val category : String?,

    @Column
    val amount: Int?,

    @Column
    val price: Int?
)
