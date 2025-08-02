package com.example.demo.solidprinciple;

public class main {

    public static  void main(String[] arg){
        IEmployeeWithBonus contract = new ContractEmployee(100, 2000);
        Integer contractBonus= contract.getBonus();

        Employee permanentEmployee = new PermanentEmployee(100, 2000);
        Integer permanentEmployeeBonus= permanentEmployee.getBonus();

      //  System.out.println(bonus);
    }
}
