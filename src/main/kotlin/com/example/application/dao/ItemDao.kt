package com.example.application.dao

import com.example.application.entities.Item
import org.springframework.data.repository.CrudRepository

interface ItemDao : CrudRepository<Item, Int>{
    fun findItemById(id: Int): Item?
}
