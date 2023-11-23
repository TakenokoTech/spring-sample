package tech.takenoko.spring.application.service

import org.springframework.stereotype.Service
import tech.takenoko.spring.domain.model.User
import tech.takenoko.spring.domain.repository.UserRepository
import tech.takenoko.spring.domain.service.UserService
import tech.takenoko.spring.domain.value.UserId
import tech.takenoko.spring.domain.value.UserName

@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
) : UserService {
    override fun getAll(): List<User> {
        return userRepository.selectAll()
    }

    override fun add(name: UserName) {
        return userRepository.insert(User(name))
    }

    override fun update(id: UserId, name: UserName) {
        return userRepository.update(User(id, name))
    }

    override fun delete(id: UserId, name: UserName) {
        return userRepository.delete(User(id, name))
    }
}
