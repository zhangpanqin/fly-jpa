package com.fly.jpa.filter;

import org.springframework.stereotype.Repository;

@Repository
public interface BlogWithPermissionJpaRepository extends DataPermissionJpaRepository<BlogWithPermissionEntity, Long> {

}
