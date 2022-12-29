package com.example.application.dao

import com.example.application.entities.Order
import org.springframework.data.repository.CrudRepository

interface OrderDao: CrudRepository<Order, Int> {
    fun findOrderById(id: Int): Order?
}
