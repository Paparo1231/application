package com.example.application.service

import com.example.application.dao.ItemDao
import com.example.application.entities.Item
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ItemServiceTest {
    private var itemDao = mockk<ItemDao>()
    private val sut: ItemServiceImpl = ItemServiceImpl(itemDao)

    @Test
    fun someTest() {
        // given
        val item1 = Item(
            id = 1,
            itemName = "Это самое",
            category = "Категория",
            amount = 3,
            price = 5000
        )
        every { itemDao.findAll() } returns arrayListOf(item1)

        // when
        val result = sut.findAll()

        // then
        assertEquals(1,result.size)
    }
}
