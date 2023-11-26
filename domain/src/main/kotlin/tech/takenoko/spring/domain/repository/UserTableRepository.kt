package tech.takenoko.spring.domain.repository

import org.springframework.data.jpa.repository.JpaRepository
import tech.takenoko.spring.domain.model.UserTable

interface UserTableRepository : JpaRepository<UserTable, Long>
