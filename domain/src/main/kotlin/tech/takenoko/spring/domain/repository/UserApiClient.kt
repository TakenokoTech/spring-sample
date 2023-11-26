package tech.takenoko.spring.domain.repository

import tech.takenoko.spring.domain.model.Log

interface UserApiClient {
    fun get(): Log
    fun post(log: Log)
}
