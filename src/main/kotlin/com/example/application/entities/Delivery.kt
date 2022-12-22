package com.example.application.entities

import javax.persistence.*

@Entity
@Table(name = "delivery_table")
data class Delivery(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    @Column
    val user_id: Int = 0,

    @Column
    val item_id : Int = 0,

    @Column
    val date_of_deliverance : String,

    @Column
    val status: String
) {

}
