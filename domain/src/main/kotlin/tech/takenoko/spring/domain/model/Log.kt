package tech.takenoko.spring.domain.model

import tech.takenoko.spring.domain.value.LogContent

data class Log(
    val id: Int?,
    val content: LogContent,
) {
    constructor(content: LogContent) : this(id = null, content = content)
}

