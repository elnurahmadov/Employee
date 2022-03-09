package com.aykan.domain.employee;

import javax.persistence.*;
import java.util.List;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "department_id")
    private Long departmentId;
    @Column
    private String departmentName;
    @ManyToOne(targetEntity = Location.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", foreignKey = @ForeignKey(foreignKeyDefinition = "location_fk"))
    private Location location;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
    private List<Employee> employees;

    public Department() {
    }

    public Department(String departmentName, Location location, List<Employee> employees) {
        this.departmentName = departmentName;
        this.location = location;
        this.employees = employees;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;

        Department that = (Department) o;

        return getDepartmentId() != null ? getDepartmentId().equals(that.getDepartmentId()) : that.getDepartmentId() == null;
    }

    @Override
    public int hashCode() {
        return getDepartmentId() != null ? getDepartmentId().hashCode() : 0;
    }
}
