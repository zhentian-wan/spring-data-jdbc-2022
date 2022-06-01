package com.loonycorn.SpringDataJDBC;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.annotation.processing.Generated;

@Table("EmployeeDetails")
public class EmployeeDetails {
    @Id
    @Column("employeeId")
    private Integer employeeId;

    @Column("firstName")
    private String firstName;

    @Column("lastName")
    private String lastName;

    @Column("designation")
    private int designation;

    public EmployeeDetails(Integer employeeId, final String firstName, final String lastName, final int designation) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.designation = designation;
    }

    static EmployeeDetails create(Integer employeeId, String firstName, String lastName, int designation) {
        return new EmployeeDetails(employeeId, firstName, lastName, designation);
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDesignation() {
        return designation;
    }

    public void setEmployeeId(final Integer employeeId) {
        this.employeeId = employeeId;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public void setDesignation(final int designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "EmployeeDetails{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", designation='" + designation + '\'' +
                '}';
    }
}
