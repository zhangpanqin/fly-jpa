package com.fly.jpa.filter;

import com.fly.jpa.common.jpa.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import java.io.Serial;

@Getter
@FilterDef(name = "filterByDeptId", parameters = {
    @ParamDef(name = "deptId", type = long.class)
})
@Filter(name = "filterByDeptId", condition = "dept_id = :deptId")
@MappedSuperclass
public abstract class DataPermission extends BaseEntity {
    @Serial
    private static final long serialVersionUID = 6277296905447082902L;
    @Column
    private Long deptId;

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }
}
