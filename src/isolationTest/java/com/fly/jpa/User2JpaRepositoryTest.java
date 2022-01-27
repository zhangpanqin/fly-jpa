package com.fly.jpa;

import cn.hutool.core.collection.CollectionUtil;
import com.fly.jpa.blog.infrastructure.repository.jpa.User2JpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

import static com.fly.jpa.ConstantMethod.buildBlog2Entity;
import static com.fly.jpa.ConstantMethod.buildUser2Entity;

/**
 * 测试 orphanRemoval
 *
 * @author 张攀钦
 * @title
 */

//@Transactional
class User2JpaRepositoryTest extends BaseIsolationTest {

    @Autowired
    private User2JpaRepository repository;

    @Test
    void should_save_user_and_blog() {
        var user2Entity = buildUser2Entity();
        user2Entity.setBlogs(Set.of(buildBlog2Entity()));
        repository.save(user2Entity);

        var all = repository.findAll();
    }

    @Test
    void should_delete_a_log_when_remove_form_set() {
        var all = repository.findAll();
        if (CollectionUtil.isNotEmpty(all)) {
            var user2Entity = all.get(0);
            user2Entity.setBlogs(Set.of());
            repository.save(user2Entity);
        }
    }

    @Test
    void should_cascade_delete_blog() {
        var all = repository.findAll();
        if (CollectionUtil.isNotEmpty(all)) {
            var user2Entity = all.get(0);
            repository.deleteById(user2Entity.getId());
        }
    }


}
