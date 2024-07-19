package com.amazon.yudoo.model;

import com.amazon.yudoo.model.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "m_user")
public class User extends BaseEntity {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "email", referencedColumnName = "email")
    private UserCredential userCredential;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "profile_picture_url")
    private String profilePictureUrl;

    private Timestamp emailVerificationDate;

    private String rememberToken;
}
