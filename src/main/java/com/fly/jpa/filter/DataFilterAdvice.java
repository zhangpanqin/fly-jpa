package com.fly.jpa.filter;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component
@Aspect
@RequiredArgsConstructor
public class DataFilterAdvice {

    private final EntityManager entityManager;

    @Before("within(com.fly.jpa.filter.DataPermissionJpaRepository+) && execution(* *(..))")
    public void doProcess() throws Throwable {
        Session session = entityManager.unwrap(Session.class);
        Filter filter = session.enableFilter("filterByDeptId");
        filter.setParameter("deptId", 1L);
        filter.validate();
    }
}