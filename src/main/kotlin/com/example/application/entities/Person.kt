package com.example.application.entities

import javax.persistence.*
import javax.validation.constraints.NotEmpty

@Entity
@Table(name = "users_table")
data class Person(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,
    @Column
    @NotEmpty(message = "Имя обязательно для заполнения")
    val name: String?,
    @Column
    @NotEmpty(message = "Отчество обязательно для заполнения")
    val patronymic: String?,
    @Column
    @NotEmpty(message = "Фамилия обязательна для заполнения")
    val surname: String?,
    @Column
    @NotEmpty(message = "Логин обязателен для заполнения")
    val login: String?,
    @Column
    @NotEmpty(message = "Пароль обязателен для заполнения")
    val password: String?,
    @Column
    @NotEmpty(message = "Номер телефона обязателен для заполнения")
    val phone_number: String?,
    @Column
    @NotEmpty(message = "Электронная почта обязательна для заполнения")
    val email: String?,
    @Enumerated(EnumType.STRING)
    @Column
    var status: RoleStatus?
)
