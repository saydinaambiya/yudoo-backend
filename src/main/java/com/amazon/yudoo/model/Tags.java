package com.amazon.yudoo.model;

import com.amazon.yudoo.model.base.BaseEntityAudit;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "m_tags")
public class Tags extends BaseEntityAudit implements Serializable {
    private String tagName;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "created_by",referencedColumnName = "id")
    private User createdBy;
}
