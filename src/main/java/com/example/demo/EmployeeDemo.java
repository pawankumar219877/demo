package com.example.demo;

import com.example.demo.builder.DepartmentBuilder;
import com.example.demo.builder.EmployeeBuilder;
import com.example.demo.builder.GroupBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmployeeDemo {
    private static <T> Predicate<T> distinctByKeys(final Function<? super T, ?>... keyExtractors)
    {
        final Map<List<?>, Boolean> seen = new ConcurrentHashMap<>();

        return t ->
        {
            final List<?> keys = Arrays.stream(keyExtractors)
                    .map(ke -> ke.apply(t))
                    .collect(Collectors.toList());

            return seen.putIfAbsent(keys, Boolean.TRUE) == null;
        };
    }
    public static void main(String[] arg){

        /**
         * Group list
         */
        Group teacherGroup = new GroupBuilder().withGroupId(1l).withGroupName("teacherGroup").build();
        Group managementGroup = new GroupBuilder().withGroupId(2l).withGroupName("managementGroup").build();
        Group adminGroup = new GroupBuilder().withGroupId(2l).withGroupName("adminGroup").build();
        List<Group>  techManageGroupList= Arrays.asList(teacherGroup,managementGroup);
        List<Group>  techGroupList= Arrays.asList(teacherGroup);
        List<Group>  manageGroupList= Arrays.asList(managementGroup);
        List<Group>  techAdminGroupList= Arrays.asList(teacherGroup,adminGroup);
        List<Group>  adminManageGroupList= Arrays.asList(managementGroup,adminGroup);

        /**
         * Department
         */
        Department teacherDepart = new DepartmentBuilder().withDepartmentId(1l).withDepartmentName("teacher").build();
        Department hodDepart = new DepartmentBuilder().withDepartmentId(2l).withDepartmentName("hod").build();
        Department principalDepart = new DepartmentBuilder().withDepartmentId(2l).withDepartmentName("principal").build();

        /**
         * Employee
         */
        Employee  pawanEmployee  =new EmployeeBuilder().withEmailId("pawan@gmail.com").withId(1l).withName("pawan")
                .withGroupList(techManageGroupList).withDepartment(teacherDepart).build();

        Employee  pawanEmployeeDup  =new EmployeeBuilder().withEmailId("pawan@gmail.com").withId(1l).withName("pawan")
                .withGroupList(techManageGroupList).withDepartment(teacherDepart).build();

        Employee  ramEmployee = new EmployeeBuilder().withEmailId("ram@gmail.com").withId(2l).withName("ram")
                .withGroupList(techGroupList).withDepartment(hodDepart).build();

        Employee  pawanEmployeeNameDup = new EmployeeBuilder().withEmailId("pawan123@gmail.com").withId(3l).withName("pawan")
                .withGroupList(manageGroupList).withDepartment(principalDepart).build();

        Employee  raviEmployee = new EmployeeBuilder().withEmailId("ravi@gmail.com").withId(3l).withName("ravi")
                .withGroupList(techAdminGroupList).withDepartment(teacherDepart).build();


       List<Employee> employeeList=Arrays.asList(pawanEmployee,ramEmployee,pawanEmployeeDup,raviEmployee,pawanEmployeeNameDup);

      //  System.out.println(employeeList);
        /**
         *  Q1 Remove  the duplicate  by  name and emailId
         */
        employeeList.stream().filter(distinctByKeys(Employee::getEmailId,Employee::getName)).collect(Collectors.toList()).forEach(e->System.out.println(e));


        /**
         * get list of emails
         */
        List<String> listOfEmail= employeeList.stream().map(Employee::getEmailId).collect(Collectors.toList());



   /*
    Map<String, List<Integer>> result = personStream.collect(Collectors.groupingBy(p -> p.name,
                                                         Collectors.mapping(e -> e.age, Collectors.toList())));

    */
      //  List<Employee> employeeList1= employeeList.stream().distinct().collect(Collectors.mapping(e->e.getDepartment(),Collectors.toList()));

    }
}
