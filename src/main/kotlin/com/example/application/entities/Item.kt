package com.example.application.entities

import javax.persistence.*


@Entity
@Table(name = "item_table")
class Item(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Int = 0,

    @Column
    val item_name : String,

    @Column
    val category : String,

    @Column
    val stock: String
) {

}
