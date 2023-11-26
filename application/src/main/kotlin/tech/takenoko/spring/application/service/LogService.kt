package tech.takenoko.spring.application.service

import org.springframework.stereotype.Service
import tech.takenoko.spring.domain.model.Log
import tech.takenoko.spring.domain.model.LogTable
import tech.takenoko.spring.domain.repository.LogTableRepository
import tech.takenoko.spring.domain.value.LogContent

@Service
class LogService(
    private val logTableRepository: LogTableRepository,
) {
    fun getAll(): List<Log> {
        return logTableRepository.findAll().map { Log(it.id, LogContent(it.content)) }
    }

    fun add(content: String) {
        logTableRepository.save(LogTable(content = content))
    }
}
