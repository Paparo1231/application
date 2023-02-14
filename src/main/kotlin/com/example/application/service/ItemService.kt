package com.example.application.service

import com.example.application.dto.CreateItemDto
import com.example.application.entities.Item

interface ItemService {
    fun findAll() : List<Item>

    fun findById(id: Int) : Item

    fun create(request: CreateItemDto): Item

    fun update(id: Int, request: CreateItemDto): Item

    fun delete(id: Int)
}
