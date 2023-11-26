package tech.takenoko.spring.presentation.controller

import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import tech.takenoko.spring.application.service.LogService
import tech.takenoko.spring.presentation.request.LogPostIndexRequest
import tech.takenoko.spring.presentation.request.LogPostIndexResponse
import tech.takenoko.spring.presentation.response.LogGetIndexResponse

@RestController
@RequestMapping("/logs")
class LogController(
    private val logService: LogService,
) {
    @GetMapping
    fun getIndex(pageable: Pageable): LogGetIndexResponse {
        val log = logService.getAll().first()
        return LogGetIndexResponse(log)
    }

    @PostMapping
    fun postIndex(@RequestBody request: LogPostIndexRequest): LogPostIndexResponse {
        logService.add(content = request.content)
        return LogPostIndexResponse
    }
}
