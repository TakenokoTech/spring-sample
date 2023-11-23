package tech.takenoko.spring.application.controller

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import tech.takenoko.spring.domain.service.UserService
import tech.takenoko.spring.domain.value.UserId
import tech.takenoko.spring.domain.value.UserName

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService,
) {
    @GetMapping
    fun getIndex(): Any {
        return userService.getAll()
    }

    @PostMapping
    fun postIndex(): Any {
        return userService.add(UserName())
    }

    @PutMapping("{id}")
    fun putIndex(@PathVariable id: Int): Any {
        return userService.update(UserId(id), UserName())
    }

    @DeleteMapping("{id}")
    fun deleteIndex(@PathVariable id: Int): Any {
        return userService.delete(UserId(id), UserName())
    }
}
