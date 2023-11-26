package tech.takenoko.spring.domain.value

import java.util.UUID

data class UserName(val value: String) {
    constructor() : this(UUID.randomUUID().toString())
}
