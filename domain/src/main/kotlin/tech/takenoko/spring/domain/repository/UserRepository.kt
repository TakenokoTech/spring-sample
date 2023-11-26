package tech.takenoko.spring.domain.repository

import tech.takenoko.spring.domain.model.User

interface UserRepository {
    fun selectAll(): List<User>
    fun insert(user: User)
    fun update(user: User)
    fun delete(user: User)
}
