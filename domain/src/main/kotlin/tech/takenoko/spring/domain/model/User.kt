package tech.takenoko.spring.domain.model

import tech.takenoko.spring.domain.value.UserId
import tech.takenoko.spring.domain.value.UserName

data class User(
    val id: UserId?,
    val username: UserName,
) {
    constructor(username: UserName) : this(id = null, username = username)
}
