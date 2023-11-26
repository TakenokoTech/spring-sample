package tech.takenoko.spring.infra.database

import org.springframework.stereotype.Component
import tech.takenoko.spring.domain.model.User
import tech.takenoko.spring.domain.model.UserTable
import tech.takenoko.spring.domain.repository.UserRepository
import tech.takenoko.spring.domain.repository.UserTableRepository
import tech.takenoko.spring.domain.value.UserName

@Component
class UserRepositoryImpl(
    private val userTableRepository: UserTableRepository,
) : UserRepository {
    override fun selectAll(): List<User> {
        return userTableRepository.findAll().map { User(UserName(it.username)) }
    }

    override fun insert(user: User) {
        val username = requireNotNull(user.username)
        userTableRepository.save(UserTable(username = username.value))
    }

    override fun update(user: User) {
        val userId = requireNotNull(user.id)
        val username = requireNotNull(user.username)
        userTableRepository.save(UserTable(id = userId.value, username = username.value))
    }

    override fun delete(user: User) {
        val userId = requireNotNull(user.id)
        val username = requireNotNull(user.username)
        userTableRepository.delete(UserTable(id = userId.value, username = username.value))
    }
}
