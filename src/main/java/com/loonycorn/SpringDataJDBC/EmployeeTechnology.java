package com.loonycorn.SpringDataJDBC;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("Employee_Technology")
public class EmployeeTechnology {
    @Id
    private int id;

    @Column("employeeId")
    private Integer employeeId;

    @Column("technologyId")
    private Long technologyId;

    public int getId() {
        return id;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public Long getTechnologyId() {
        return technologyId;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public void setEmployeeId(final Integer employeeId) {
        this.employeeId = employeeId;
    }

    public void setTechnologyId(final Long technologyId) {
        this.technologyId = technologyId;
    }

    @Override
    public String toString() {
        return "EmployeeTechnology{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", technologyId=" + technologyId +
                '}';
    }
}
