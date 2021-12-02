package com.fly.jpa.common.jpa;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author zhangpanqin
 * 审计相关的东西
 */
@Component
public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.ofNullable("SYSTEM");
    }

}