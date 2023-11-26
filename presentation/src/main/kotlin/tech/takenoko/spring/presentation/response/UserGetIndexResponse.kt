package tech.takenoko.spring.presentation.response

import com.fasterxml.jackson.annotation.JsonInclude
import org.springframework.data.domain.Page
import tech.takenoko.spring.domain.model.User

data class UserGetIndexResponse(
    val data: List<UserResponse>,
    val meta: MetaResponse,
) {
    constructor(
        users: List<User>,
        page: Page<*>? = null,
    ) : this(
        data = users.map(::UserResponse),
        meta = MetaResponse(page),
    )

    data class UserResponse(
        val id: Int,
        val username: String,
    ) {
        constructor(user: User) : this(
            user.id?.value ?: 0,
            user.username.value,
        )
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    data class MetaResponse(
        val all: Boolean?,
        val first: Boolean?,
        val last: Boolean?,
        val size: Int?,
        val page: Int?,
        val total: Int?,
    ) {
        constructor(page: Page<*>?) : this(
            all = page?.let { it.totalPages == 1 } ?: true,
            first = page?.isFirst,
            last = page?.isLast,
            size = page?.size,
            page = page?.number,
            total = page?.totalPages,
        )
    }
}
