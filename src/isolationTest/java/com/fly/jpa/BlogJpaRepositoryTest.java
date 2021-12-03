package com.fly.jpa;

import com.fly.jpa.blog.Infrastructure.entity.BlogEntity;
import com.fly.jpa.blog.Infrastructure.repository.jpa.BlogJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import javax.transaction.Transactional;
import java.util.List;

import static com.fly.jpa.ConstantMethod.buildBlogEntity;
import static com.fly.jpa.blog.Infrastructure.repository.jpa.BlogJpaRepository.buildEqContent;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.data.domain.Sort.Direction.ASC;

@Transactional
class BlogJpaRepositoryTest extends BaseIsolationTest {

    @Autowired
    private BlogJpaRepository repository;

    @Test
    void should_find_by_sort() {
        var entity2 = buildBlogEntity();
        entity2.setUserId(2L);
        var entity = buildBlogEntity();
        entity.setUserId(1L);
        repository.saveAll(List.of(entity, entity2));
        var entities = repository.findAllByTitle("string", Sort.by(ASC, "userId"));

        assertThat(entities)
                .satisfiesExactly(
                        it -> assertThat(it)
                                .returns(1L, BlogEntity::getUserId),
                        it -> assertThat(it)
                                .returns(2L, BlogEntity::getUserId)
                );
    }

    @Test
    void should_find_by_page() {
        var entity2 = buildBlogEntity();
        entity2.setUserId(2L);
        var entity = buildBlogEntity();
        entity.setUserId(1L);
        repository.saveAll(List.of(entity, entity2));

        var entities = repository.findAllByTitle("string", PageRequest.of(0, 1, Sort.by(ASC, "userId")));

        assertThat(entities)
                .satisfiesExactly(
                        it -> assertThat(it)
                                .returns(1L, BlogEntity::getUserId)
                );
    }

    @Test
    void should_find_by_content() {
        var entity2 = buildBlogEntity();
        entity2.setUserId(2L);
        var entity = buildBlogEntity();
        entity.setUserId(1L);
        repository.saveAll(List.of(entity, entity2));

        var entities = repository.findAllByContent("content2");

        assertThat(entities)
                .hasSize(2)
                .satisfiesExactlyInAnyOrder(
                        it -> assertThat(it)
                                .returns(1L, BlogEntity::getUserId),
                        it -> assertThat(it)
                                .returns(2L, BlogEntity::getUserId)
                );
    }

    @Test
    void should_find_all_title() {
        var entity2 = buildBlogEntity();
        entity2.setUserId(2L);
        var entity = buildBlogEntity();
        entity.setUserId(1L);
        repository.saveAll(List.of(entity, entity2));

        var entities = repository.findAllTitle();

        assertThat(entities)
                .hasSize(2)
                .satisfiesExactlyInAnyOrder(
                        it -> assertThat(it)
                                .isEqualTo("string"),
                        it -> assertThat(it)
                                .isEqualTo("string")
                );
    }

    @Test
    void should_find_by_spec(){
        var entity2 = buildBlogEntity();
        entity2.setUserId(2L);
        var entity = buildBlogEntity();
        entity.setUserId(1L);
        repository.saveAll(List.of(entity, entity2));

        var entities = repository.findAll(buildEqContent("content2"));

        assertThat(entities)
                .hasSize(2)
                .satisfiesExactlyInAnyOrder(
                        it -> assertThat(it)
                                .returns(1L, BlogEntity::getUserId),
                        it -> assertThat(it)
                                .returns(2L, BlogEntity::getUserId)
                );
    }
}