package com.example.demo.solidprinciple;

public class ContractEmployee implements IEmployeeWithBonus{
    Integer salary;
    Integer bonus;
    ContractEmployee(Integer salary, Integer bonus) {
        this.salary =salary;
        this.bonus =bonus;
    }

    public Integer getSalary(){
        return salary;
    }

    public Integer getBonus(){
        return bonus;
    }
}
