package com.example.application.dao

import com.example.application.entities.Message
import org.springframework.data.repository.CrudRepository
import java.time.LocalDate

interface MessageDao : CrudRepository<Message, LocalDate> {
    fun findMessageByCreationDate(date: LocalDate) : Message
}
