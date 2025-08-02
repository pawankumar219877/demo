package com.example.demo.solidprinciple;

public class Employee {
    Integer salary;
    Integer bonus;
    Employee(Integer salary,Integer bonus){
        this.salary =salary;
        this.bonus =bonus;
    }
    public Integer getSalary(){
        return salary;
    }

    public Integer getBonus(){
        System.out.println(this.getClass());
        return bonus;
    }
}
