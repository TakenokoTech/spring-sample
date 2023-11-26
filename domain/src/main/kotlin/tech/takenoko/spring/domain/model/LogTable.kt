package tech.takenoko.spring.domain.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EntityListeners
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.CreationTimestamp
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@Entity
@Table(name = "logs")
@EntityListeners(AuditingEntityListener::class)
data class LogTable(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    @Column(name = "content")
    val content: String = "",
) {
    @field:CreationTimestamp
    @Column(name = "created_at", updatable = false)
    lateinit var createdAt: LocalDateTime
}

