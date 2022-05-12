package com.fmgarcia.umbrella.notifications.repository;

import com.fmgarcia.umbrella.notifications.domain.EmailTemplate;
import com.fmgarcia.umbrella.notifications.domain.EmailType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@DataJpaTest
public class EmailTemplateRepositoryTest {

    @Autowired
    private DataSource dataSource;
    @Autowired private JdbcTemplate jdbcTemplate;
    @Autowired private EntityManager entityManager;
    @Autowired private EmailTemplateRepository emailTemplateRepository;

    private EmailTemplate emailTemplate;

    @BeforeEach
    public void setup(){
        emailTemplate = EmailTemplate.builder()
                .content("A.K.A Content")
                .description("Description")
                .enabled(true)
                .name("Template-X")
                .subject("Test send Email")
                .type(EmailType.HTML)
                .build();
    }

    @Test
    void injectedComponentsAreNotNull(){
        assertThat(dataSource).isNotNull();
        assertThat(jdbcTemplate).isNotNull();
        assertThat(entityManager).isNotNull();
        assertThat(emailTemplateRepository).isNotNull();
    }

    @DisplayName("Save new EmailTemplate")
    @Test
    void whenSaved_thenFindByName() {
        // GIVEN

        // WHEN
        EmailTemplate result = emailTemplateRepository.save(emailTemplate);
        Long id = result.getId();

        // THEN
        assertThat(result).isNotNull();
        assertThat(result.getId()).isGreaterThan(0);

        List<EmailTemplate> emailTemplateList = emailTemplateRepository.findAll();
        assertThat(emailTemplateList).isNotNull();
        assertThat(emailTemplateList.size()).isEqualTo(1);

        EmailTemplate emailTemplateFound = emailTemplateRepository.findById(id).get();
        log.info(emailTemplateFound.toString());
        assertThat(emailTemplateFound).isNotNull();
        assertThat(emailTemplateFound.getName()).isEqualTo("Template-X");
        assertThat(emailTemplateFound.getUuid()).isNotNull();
        //assertThat(emailTemplateRepository.findByName("Template-X").get()).isNotNull();
    }

    @DisplayName("Save new EmailTemplate and update")
    @Test
    void whenSaved_thenUpdate() {
        // GIVEN

        // WHEN
        EmailTemplate result = emailTemplateRepository.save(emailTemplate);
        result.setContent("<h1>Congratulations !!!</h1>");

        EmailTemplate emailTemplateUpdate = emailTemplateRepository.save(result);

        // THEN
        assertThat(emailTemplateUpdate).isNotNull();
        assertThat(emailTemplateUpdate.getContent()).isEqualTo("<h1>Congratulations !!!</h1>");
    }

    @DisplayName("Save new EmailTemplate and delete")
    @Test
    void whenSaved_thenDelete() {
        // GIVEN

        // WHEN
        EmailTemplate result = emailTemplateRepository.save(emailTemplate);

        emailTemplateRepository.delete(result);

        Optional<EmailTemplate> emailOptional = emailTemplateRepository.findById(1L);

        // THEN
        assertThat(emailOptional).isEmpty();
    }
}
