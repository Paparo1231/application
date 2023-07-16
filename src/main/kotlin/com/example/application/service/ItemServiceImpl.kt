package com.example.application.service

import com.example.application.dao.ItemDao
import com.example.application.dto.CreateItemDto
import com.example.application.entities.Item
import com.example.application.exceptions.ItemNotFoundException
import org.slf4j.LoggerFactory
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ItemServiceImpl(private val itemDao: ItemDao) : ItemService {

    override fun findAll() =
        itemDao.findAll().toList()
            .also { log.info("вывод всех товаров") }

    override fun findById(id: Int): Item {
        log.info("Вывод конкретного товара по id = $id")
        return itemDao.findItemById(id) ?: throw ItemNotFoundException(id)
        //return itemDao.findByIdOrNull(id) ?: throw ItemNotFoundException(id)

    }

    override fun create(request: CreateItemDto): Item =
        itemDao.save(
            Item(
                itemName = request.item_name!!,
                category = request.category!!,
                amount = request.amount!!,
                price = request.price!!
            )
        ).also {
            log.info("Создание товара с названием = ${request.item_name}")
        }

    override fun update(id: Int, request: CreateItemDto) =
        itemDao.findByIdOrNull(id)
            ?.let {
                itemDao.save(
                    it.copy(
                        itemName = request.item_name!!,
                        category = request.category!!,
                        amount = request.amount!!,
                        price = request.price!!
                    )
                )
            }
            ?.also { log.info("Изменение товара с id = $id") } ?: throw ItemNotFoundException(id)


    override fun delete(id: Int)
         = itemDao.findByIdOrNull(id)
            ?.let { itemDao.delete(it) }
            ?.also { log.info("Удаление товара с id = $id") }
            ?: throw ItemNotFoundException(id)


    companion object {
        private val log = LoggerFactory.getLogger(ItemServiceImpl::class.java)
    }
}
