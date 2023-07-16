package com.example.application.service

import com.example.application.dao.OrderDao
import com.example.application.dto.CreateOrderDto
import com.example.application.entities.Order
import com.example.application.entities.OrderStatus
import com.example.application.exceptions.OrderNotFoundException
import com.example.application.exceptions.PersonNotFoundException
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
class OrderServiceImpl(private val orderDao: OrderDao) : OrderService {
    private lateinit var itemServiceImpl : ItemServiceImpl

    override fun create(dto: CreateOrderDto) = orderDao.save(
        Order(
            personId = dto.personId,
            status = OrderStatus.CREATED,
            deliveryMethodId = dto.deliveryMethodId,
            address = dto.address

        )
    ).also { log.info("Заказ успешно создан: $it") }

    @Transactional
    fun changeOrderStatus(id: Int, status: OrderStatus) = orderDao.findOrderById(id)
        ?.let { it.copy(status = status) }
        ?: throw RuntimeException("Заказ с id=$id не был найден. Не удалось изменить статус")


    override fun findById(id: Int): Order? {
        log.info("Находим заказ с id = $id")
        return orderDao.findOrderById(id) ?: throw OrderNotFoundException(id)
    }


    override fun update(id: Int, dto: CreateOrderDto) {
        log.info("Изменение заказа с id = $id")
        val order = orderDao.findOrderById(id) ?: throw OrderNotFoundException(id)
        orderDao.save(
            order.copy(
                personId = dto.personId,
                status = OrderStatus.CREATED,
                deliveryMethodId = dto.deliveryMethodId,
                address = dto.address
            )
        )
    }

    override fun delete(id: Int) {
        log.info("Удаление заказа с id = $id") {
            val order = orderDao.findOrderById(id) ?: throw PersonNotFoundException(id)
            orderDao.delete(order)
        }
    }

    companion object {
        private val log = LoggerFactory.getLogger(ItemServiceImpl::class.java)
    }
}
