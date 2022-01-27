package com.fly.jpa.filter;

import com.fly.jpa.common.jpa.BaseEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.ParamDef;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

@FilterDef(name = "filterByDeptId", parameters = {
        @ParamDef(name = "deptId", type = "long")
})
@Filters({
        @Filter(name = "filterByDeptId", condition = "dept_id = :deptId")
})
@MappedSuperclass
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public abstract class DataPermission extends BaseEntity {
    private static final long serialVersionUID = 6277296905447082902L;
    @Column
    private Long deptId;

    @Override
    public boolean equals(Object o) {
        if (this==o) return true;
        if (o==null || Hibernate.getClass(this)!=Hibernate.getClass(o)) return false;
        DataPermission that = (DataPermission) o;
        return getId()!=null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
