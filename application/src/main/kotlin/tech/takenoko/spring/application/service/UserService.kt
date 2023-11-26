package tech.takenoko.spring.application.service

import jakarta.transaction.Transactional
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import tech.takenoko.spring.domain.model.Log
import tech.takenoko.spring.domain.model.User
import tech.takenoko.spring.domain.model.UserTable
import tech.takenoko.spring.domain.repository.UserApiClient
import tech.takenoko.spring.domain.repository.UserRepository
import tech.takenoko.spring.domain.repository.UserTableRepository
import tech.takenoko.spring.domain.value.LogContent
import tech.takenoko.spring.domain.value.UserId
import tech.takenoko.spring.domain.value.UserName
import kotlin.jvm.optionals.getOrNull

@Service
@Transactional
class UserService(
    private val userRepository: UserRepository,
    private val userTableRepository: UserTableRepository,
    private val userApiClient: UserApiClient,
) {
    fun getAll(): List<User> {
        userApiClient.post(Log(LogContent("get user")))
        return userRepository.selectAll()
    }

    fun get(pageable: Pageable): Page<UserTable> {
        userApiClient.post(Log(LogContent("get user")))
        return userTableRepository.findAll(pageable)
    }

    fun add() {
        val userName = UserName()
        userApiClient.post(Log(LogContent("add user")))
        return userRepository.insert(User(userName))
    }

    fun update(id: Int) {
        val user = userTableRepository.findById(id.toLong()).getOrNull()
        requireNotNull(user)
        userApiClient.post(Log(LogContent("update user")))
        return userRepository.update(User(UserId(user.id), UserName()))
    }

    fun delete(id: Int) {
        val user = userTableRepository.findById(id.toLong()).getOrNull()
        requireNotNull(user)
        userApiClient.post(Log(LogContent("delete user")))
        return userTableRepository.delete(user)
    }
}
