package com.example.application.service

import com.example.application.dao.OrderDao
import com.example.application.dto.CreateOrderDto
import com.example.application.entities.Order
import com.example.application.entities.OrderStatus
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
class OrderServiceImpl(private val orderDao: OrderDao) {

    fun createOrder(dto: CreateOrderDto) = orderDao.save(
        Order(
            personId = dto.personId,
            status = OrderStatus.CREATED,
            deliveryMethodId = dto.deliveryMethodId
        )
    ).also { log.info("Заказ успешно создан: $it") }

    @Transactional
    fun changeOrderStatus(id: Int, status: OrderStatus) = orderDao.findOrderById(id)
        ?.let { it.copy(status = status) }
        ?: throw RuntimeException("Заказ с id=$id не был найден. Не удалось изменить статус")

    companion object {
        private val log = LoggerFactory.getLogger(ItemServiceImpl::class.java)
    }
}
