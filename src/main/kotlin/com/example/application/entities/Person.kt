package com.example.application.entities

import javax.persistence.*

@Entity
@Table(name = "users_table")
data class Person(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,
    @Column
    val name: String?,
    @Column
    val patronymic: String?,
    @Column
    val surname: String?,
    @Column
    val login: String?,
    @Column
    val password: String?,
    @Column
    val phone_number: String?,
    @Column
    val email: String?,
    @Enumerated(EnumType.STRING)
    @Column
    var status: RoleStatus?

)
