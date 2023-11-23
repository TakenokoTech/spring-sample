package tech.takenoko.spring.infra.database

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EntityListeners
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDateTime

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener::class)
data class UserTable(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    @Column(name = "username")
    val username: String = "",
) {
    @field:CreationTimestamp
    @Column(name = "created_at", updatable = false)
    lateinit var createdAt: LocalDateTime

    @field:UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    lateinit var updatedAt: LocalDateTime

    interface Repository : JpaRepository<UserTable, Long>
}

