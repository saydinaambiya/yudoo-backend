package com.amazon.yudoo.model.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.time.LocalDateTime;

@Setter
@Getter
@MappedSuperclass
public abstract class BaseEntityAudit extends BaseEntity implements Serializable {
    @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
    @Column(updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
    @LastModifiedDate
    @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
    private LocalDateTime updatedAt;
}
