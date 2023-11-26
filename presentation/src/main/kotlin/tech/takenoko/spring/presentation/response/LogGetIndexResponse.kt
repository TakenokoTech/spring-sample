package tech.takenoko.spring.presentation.response

import tech.takenoko.spring.domain.model.Log

data class LogGetIndexResponse(
    val content: String,
) {
    constructor(log: Log) : this(
        content = log.content.value,
    )
}
