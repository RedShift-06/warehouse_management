package com.project.warehouse.database.stock;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/** Join entity User <-> Role with its own simple id (no composite key). */
@Entity
@Table(name = "user_roles",
        uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "role_id"}))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @Column(name = "assigned_at", nullable = false)
    private LocalDateTime assignedAt;

    public UserRole(User user, Role role) {
        this.user = user;
        this.role = role;
    }

    @PrePersist
    void onCreate() {
        if (assignedAt == null) assignedAt = LocalDateTime.now();
    }
}
