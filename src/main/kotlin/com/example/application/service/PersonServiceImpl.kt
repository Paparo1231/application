package com.example.application.service

import com.example.application.dao.PersonDao
import com.example.application.dto.SavePersonRequest
import com.example.application.entities.Person
import com.example.application.exceptions.PersonNotFoundException
import org.slf4j.LoggerFactory
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class PersonServiceImpl(private val personDao: PersonDao) : PersonService {
    override fun findAll(): List<Person> {
        log.info("Вывод всех людей")
        return personDao.findByOrderByName()
    }

    override fun findById(id: Int): Person {
        log.info("Находим человека с id = $id")
        return personDao.findByIdOrNull(id) ?: throw
        PersonNotFoundException(id)
    }

    override fun create(request: SavePersonRequest): Person =
        personDao.save(
            Person(
                name = request.name!!,
                patronymic = request.patronymic!!,
                surname = request.surname!!,
                login = request.login!!,
                password = request.password!!,
                phone_number = request.phone_number!!,
                status = request.status!!,
                email = request.email!!
            )
        ).also {
            log.info("Создан человек с именем = ${it.name}")
        }

    override fun update(id: Int, request: SavePersonRequest) {
        log.info("Изменение человека с id = $id")
        val person = personDao.findByIdOrNull(id) ?: throw
                PersonNotFoundException(id)
        personDao.save(
            person.copy(
                name = request.name!!,
                patronymic = request.patronymic!!,
                surname = request.surname!!,
                login = request.login!!,
                password = request.password!!,
                phone_number = request.phone_number!!,
                status = request.status!!,
                email = request.email!!
            )
        )
    }

    override fun delete(id: Int) {
        log.info("Удаление человека с id=$id")
        val person = personDao.findByIdOrNull(id) ?: throw
                PersonNotFoundException(id)
        personDao.delete(person)
    }

    companion object {
        private val log = LoggerFactory.getLogger(PersonServiceImpl::class.java)
    }
}
