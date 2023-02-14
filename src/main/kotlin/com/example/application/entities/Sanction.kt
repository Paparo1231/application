package com.example.application.entities

import javax.persistence.*

@Entity
@Table(name = "user_sanctions")
data class Sanction(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val user_id: Int = 0,

    @Column
    val role: String,

    @Column
    val status: String
) {
}
