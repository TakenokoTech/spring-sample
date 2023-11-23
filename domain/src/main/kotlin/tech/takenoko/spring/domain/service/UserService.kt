package tech.takenoko.spring.domain.service

import tech.takenoko.spring.domain.model.User
import tech.takenoko.spring.domain.value.UserId
import tech.takenoko.spring.domain.value.UserName

interface UserService {
    fun getAll(): List<User>
    fun add(name: UserName)
    fun update(id: UserId, name: UserName)
    fun delete(id: UserId, name: UserName)
}
