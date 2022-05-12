package com.fmgarcia.umbrella.notifications.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "email_templates", indexes = @Index(columnList = "uuid"))
public class EmailTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private String subject;
    private String content;
    private Boolean enabled;

    private String uuid;

    @Enumerated(EnumType.STRING)
    private EmailType type;

    @PrePersist
    public void setUUID() {
        uuid = UUID.randomUUID().toString();
    }

}
