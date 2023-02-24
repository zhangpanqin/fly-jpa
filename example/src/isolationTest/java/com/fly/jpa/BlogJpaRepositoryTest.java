package com.fly.jpa;

import com.fly.jpa.blog.infrastructure.entity.BlogEntity;
import com.fly.jpa.blog.infrastructure.repository.jpa.BlogJpaRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import java.util.List;
import static com.fly.jpa.ConstantMethod.buildBlogEntity;
import static com.fly.jpa.ConstantValue.BLOG_ID1;
import static com.fly.jpa.ConstantValue.BLOG_ID2;
import static com.fly.jpa.ConstantValue.USER_ID1;
import static com.fly.jpa.ConstantValue.USER_ID2;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.data.domain.Sort.Direction.ASC;

class BlogJpaRepositoryTest extends BaseIsolationTest {

    @Autowired
    private BlogJpaRepository repository;

    @Test
    void should_find_by_sort() {
        var entity1 = buildBlogEntity(BLOG_ID1, USER_ID1);
        var entity2 = buildBlogEntity(BLOG_ID2, USER_ID2);
        repository.saveAll(List.of(entity1, entity2));
        var entities = repository.findAllByTitle("string", Sort.by(ASC, "userId"));

        Assertions.assertThat(entities)
            .satisfiesExactlyInAnyOrder(
                it -> assertThat(it)
                    .returns(USER_ID2, BlogEntity::getUserId),
                it -> assertThat(it)
                    .returns(USER_ID1, BlogEntity::getUserId)
            );
    }
}
