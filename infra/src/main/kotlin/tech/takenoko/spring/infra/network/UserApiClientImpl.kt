package tech.takenoko.spring.infra.network

import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono
import reactor.core.publisher.Mono
import tech.takenoko.spring.domain.model.Log
import tech.takenoko.spring.domain.repository.UserApiClient
import tech.takenoko.spring.domain.value.LogContent

@Component
class UserApiClientImpl(
    private val webClient: WebClient = WebClient.create(URL),
) : UserApiClient {
    override fun get(): Log {
        return webClient.get()
            .uri(PATH_LOGS)
            .retrieve()
            .bodyToMono<UserApiRequest.GetResponseBody>()
            .block()!!
            .let { Log(id = it.id, content = LogContent(it.content)) }
    }

    override fun post(log: Log) {
        val body = UserApiRequest.PostRequestBody(log.content.value)
        webClient.post()
            .uri(PATH_LOGS)
            .contentType(APPLICATION_JSON)
            .body(Mono.just(body), body::class.java)
            .retrieve()
            .bodyToMono<Unit>()
            .block()!!
    }

    companion object {
        private const val URL = "http://localhost:8080"
        private const val PATH_LOGS = "/logs"
    }
}
