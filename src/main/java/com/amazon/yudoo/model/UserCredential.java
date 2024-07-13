package com.amazon.yudoo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "m_user_credential")
public class UserCredential {
    @Id
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    @Column(name = "is_active", columnDefinition = "boolean default true")
    private boolean isActive;
}
