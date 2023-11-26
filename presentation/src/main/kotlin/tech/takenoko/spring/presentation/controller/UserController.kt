package tech.takenoko.spring.presentation.controller

import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import tech.takenoko.spring.application.service.UserService
import tech.takenoko.spring.domain.model.User
import tech.takenoko.spring.domain.value.UserName
import tech.takenoko.spring.presentation.response.UserGetIndexResponse

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService,
) {
    @GetMapping
    fun getIndex(
        @PageableDefault(size = 10) pageable: Pageable,
        all: Boolean = false,
    ): UserGetIndexResponse {
        println("isUnpaged: ${pageable.isPaged}, offset: ${pageable.offset}, pageNumber: ${pageable.pageNumber}, pageSize: ${pageable.pageSize}, sort: ${pageable.sort}")
        return if (all) {
            val users = userService.getAll()
            UserGetIndexResponse(users = users)
        } else {
            val page = userService.get(pageable)
            val users = page.map { User(UserName(it.username)) }.toList()
            UserGetIndexResponse(users, page)
        }
    }

    @PostMapping
    fun postIndex(): Any {
        return userService.add()
    }

    @PutMapping("{id}")
    fun putIndex(@PathVariable id: Int): Any {
        return userService.update(id)
    }

    @DeleteMapping("{id}")
    fun deleteIndex(@PathVariable id: Int): Any {
        return userService.delete(id)
    }
}
