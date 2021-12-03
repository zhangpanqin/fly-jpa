package com.fly.jpa.blog.Infrastructure.repository.jpa;

import com.fly.jpa.blog.Infrastructure.entity.BlogEntity;
import com.fly.jpa.blog.Infrastructure.entity.BlogEntity_;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.LockModeType;
import java.util.List;

public interface BlogJpaRepository extends JpaRepository<BlogEntity, Long>, JpaSpecificationExecutor<BlogEntity> {

    // 要添加 jpa model 依赖
    static Specification<BlogEntity> buildEqContent(String content) {
        return (root, query, builder) ->
                builder.equal(root.get(BlogEntity_.content), content);
    }

    List<BlogEntity> findAllByTitle(String title, Sort sort);

    Page<BlogEntity> findAllByTitle(String title, Pageable pageable);

    @Query("select blog from BlogEntity blog where blog.content=:content")
    List<BlogEntity> findAllByContent(@Param("content") String content);

    @Query(value = "select title from blog", nativeQuery = true)
    List<String> findAllTitle();

    /**
     * 必须在事务内使用锁
     * OPTIMISTIC_FORCE_INCREMENT 会更新 @version 标记的字段,查询和更新数据的时候
     */

    // select for update,互斥锁,同时只有一个事务可以操作,其余等待
    //   @Lock(LockModeType.PESSIMISTIC_WRITE)


    // select for share,共享锁,会与互斥锁互斥,读读之前不阻塞
    @Lock(LockModeType.WRITE)
    List<BlogEntity> findAll();
}
