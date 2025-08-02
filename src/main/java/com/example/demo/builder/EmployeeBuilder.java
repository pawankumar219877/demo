package com.example.demo.builder;

import com.example.demo.Department;
import com.example.demo.Employee;
import com.example.demo.Group;

import java.util.List;

public class EmployeeBuilder {

    private Employee employee;

    private String name;

    private String emailId;

    private Long id;

    private List<Group> groupList;

    private Department department;

    public EmployeeBuilder() {
        this.employee = new Employee();
    }

    public EmployeeBuilder withName(String name) {
        this.employee.setName(name);
        return this;
    }


    public EmployeeBuilder withEmailId(String emailId) {
        this.employee.setEmailId(emailId);
        return this;
    }

    public EmployeeBuilder withId(Long id) {
        this.employee.setId(id);
        return this;
    }

    public EmployeeBuilder withDepartment(Department department) {
        this.employee.setDepartment(department);
        return this;
    }


    public EmployeeBuilder withGroupList(List<Group> groupList) {
        this.employee.setGroupList(groupList);
        return this;
    }


    public Employee build() {
        return employee;
    }

}
