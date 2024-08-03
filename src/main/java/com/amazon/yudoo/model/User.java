package com.amazon.yudoo.model;

import com.amazon.yudoo.model.base.BaseEntity;
import com.amazon.yudoo.model.base.BaseEntityAudit;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Setter
@Getter
@Table(name = "m_user")
public class User extends BaseEntityAudit {

    @JoinColumn(name = "email", referencedColumnName = "email",table = "m_user_credential")
    private String email;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "profile_picture_url")
    private String profilePictureUrl;

    @Column(name = "email_verification_date")
    private Timestamp emailVerificationDate;
}
