package com.fmgarcia.umbrella.notifications.repository;

import com.fmgarcia.umbrella.notifications.domain.EmailTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmailTemplateRepository extends JpaRepository<EmailTemplate, Long> {

    public Optional<EmailTemplate> findByUuid(String uuid);

    public Optional<EmailTemplate> findByName(String name);
}
