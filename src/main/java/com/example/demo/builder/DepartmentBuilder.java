package com.example.demo.builder;

import com.example.demo.Department;

public class DepartmentBuilder {

    private Department department;
    private String departmentName;

    private Long departId;

    public DepartmentBuilder() {
        department = new Department();
    }

    public DepartmentBuilder withDepartmentName(String departmentName) {
        this.department.setDepartmentName(departmentName);
        return this;
    }

    public DepartmentBuilder withDepartmentId(Long departId) {
        this.department.setDepartId(departId);
        return this;
    }


    public Department build() {
        return department;
    }
}
