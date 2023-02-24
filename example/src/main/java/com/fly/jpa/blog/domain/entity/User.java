package com.fly.jpa.blog.domain.entity;

import com.fly.jpa.common.domain.BaseDomain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class User extends BaseDomain {
    private Long id;
    private String name;
    private List<Blog> blogs;
}
