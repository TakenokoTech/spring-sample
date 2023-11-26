package tech.takenoko.spring.domain.repository

import org.springframework.data.jpa.repository.JpaRepository
import tech.takenoko.spring.domain.model.LogTable

interface LogTableRepository : JpaRepository<LogTable, Long>
