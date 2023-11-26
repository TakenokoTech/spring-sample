package tech.takenoko.spring.infra.network

sealed class UserApiRequest {
    data class GetResponseBody(val id: Int, val content: String) : UserApiRequest()
    data class PostRequestBody(val content: String) : UserApiRequest()
}
