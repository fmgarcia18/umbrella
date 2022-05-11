package com.fmgarcia.umbrella.notifications.repository;

import com.fmgarcia.umbrella.notifications.domain.EmailTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailTemplateRepository extends JpaRepository<EmailTemplate, Long> {
}
