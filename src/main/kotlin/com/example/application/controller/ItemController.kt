package com.example.application.controller

import com.example.application.dto.CreateItemDto
import com.example.application.entities.Item
import com.example.application.service.ItemService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping(
    "/items", produces =
    [MediaType.APPLICATION_JSON_VALUE]
)
class ItemController(
    private val itemService: ItemService
) {
    @GetMapping
    fun findAll() = itemService.findAll()

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id: Int): Item = itemService.findById(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@Valid @RequestBody request: CreateItemDto
    ) = itemService.create(request)

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    fun update(
        @PathVariable("id") id: Int,
        @Valid @RequestBody request: CreateItemDto
    ) = itemService.update(id, request)

    @DeleteMapping("{id}")
    fun deletePerson(@PathVariable("id") id: Int) = itemService.delete(id)
}
