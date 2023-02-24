package com.fly.jpa;

import com.fly.jpa.blog.infrastructure.entity.BlogEntity;
import com.fly.jpa.filter.BlogWithPermissionEntity;
import com.fly.jpa.filter.BlogWithPermissionJpaRepository;
import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import static com.fly.jpa.ConstantMethod.buildBlogWithPermissionEntity;
import static com.fly.jpa.ConstantValue.BLOG_ID1;
import static com.fly.jpa.ConstantValue.BLOG_ID2;
import static com.fly.jpa.ConstantValue.DEPT_ID1;
import static com.fly.jpa.ConstantValue.DEPT_ID2;
import static com.fly.jpa.ConstantValue.USER_ID1;
import static com.fly.jpa.ConstantValue.USER_ID2;
import static org.assertj.core.api.Assertions.assertThat;

class BlogWithPermissionJpaRepositoryTest extends BaseIsolationTest {
    @Autowired
    private BlogWithPermissionJpaRepository repository;

    @Autowired
    private EntityManager entityManager;

    @Test
    void should_find_by_sort() {
        var entity1 = buildBlogWithPermissionEntity(BLOG_ID1, DEPT_ID1);
        var entity2 = buildBlogWithPermissionEntity(BLOG_ID2, DEPT_ID2);


        Session session = entityManager.unwrap(Session.class);
        Filter filter = session.enableFilter("filterByDeptId");
        filter.setParameter("deptId", 1L);
        filter.validate();

        repository.saveAll(List.of(entity1, entity2));
        var entities = repository.findAll();

        Assertions.assertThat(entities)
            .satisfiesExactlyInAnyOrder(
                it -> assertThat(it)
                    .returns(BLOG_ID1, BlogWithPermissionEntity::getId)
            );
    }
}
