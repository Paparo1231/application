package com.example.application.entities

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "delivery_table")
 data class Delivery(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    @Column
    val userId: Int = 0,

    @Column
    val itemId : Int = 0,

    @Column
    val dateOfDeliverance : LocalDate,

    @Column
    @Enumerated(EnumType.STRING)
    val status: DeliveryStatus
) {

}
