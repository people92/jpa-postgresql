package com.ssg.people92.jpa_postgresql.config;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class BasicAuditor implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("jpa-postgresql");
    }
}
