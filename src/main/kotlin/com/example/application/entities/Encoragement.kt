package com.example.application.entities

import javax.persistence.*


@Entity
@Table(name = "user_encoragements")
data class Encoragement(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    @Column
    val userId : Int,

    @Column
    val role: Role,

    @Column
    val status: UserStatus
) {

}
