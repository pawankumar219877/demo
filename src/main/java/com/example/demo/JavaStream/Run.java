package com.example.demo.JavaStream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Run {
    public static void main(String[] arg) {
        Employee emp1 = new Employee(1, "pawan", "it", 120l);
        Employee emp2 = new Employee(2, "Amit", "it", 10l);
        Employee emp4 = new Employee(3, "Raju", "hr", 1200l);
        Employee emp5 = new Employee(3, "Raju", "hr", 1500l);
        List<Employee> employeeList = Arrays.asList(emp1, emp2, emp4, emp5);

       // getEmployeeListByMaxSalaryGroupByDeptUsingSorted(employeeList);

        /* Double abc= 10d/3;
         System.out.println(String.format("%.2f",abc)); */

        Subject s1 = new Subject("Math", "this is math subject");
        Subject s2 = new Subject("Chem", "this is Chem subject Chem");
        Subject s3 = new Subject("bio", "this is  subject Chem");
        List<Subject> sublist = Arrays.asList(s1, s2);
        List<Subject> sublist2 = Arrays.asList(s2, s3);

        Student sd1 = new Student("Pawan", 12, sublist);

        Student sd2 = new Student("Mohan", 16, sublist2);

        Student sd3 = new Student("Amit", 17, sublist2);

        List<Student> stList = Arrays.asList(sd1, sd2, sd3);

        // sort by student name wise desc
        stList.stream().sorted((stu1, stu2) -> stu2.name.compareTo(stu1.getName())).map(Student::getName).forEach(System.out::println);


        // other way to sort by student name wise desc
        // Collections.sort(stList,(stu1,stu2)->stu2.name.compareTo(stu1.getName()));

/*
        List<Subject> studentSubjectList = stList.stream().flatMap(s->s.getSubject().stream())
                .collect(Collectors.toList());
        System.out.println(studentSubjectList);


        List<String> studentSubjectNameList = stList.stream().flatMap(s-> s.getSubject().stream()
                            .flatMap(item->Stream.of(item.getSubjectName())))
                            .collect(Collectors.toList());
        System.out.println(studentSubjectNameList);


        Set<String> uniquSubjectNameList = stList.stream().flatMap(s-> s.getSubject().stream()
                        .flatMap(item->Stream.of(item.getSubjectName())))
                .collect(Collectors.toSet());
        System.out.println(uniquSubjectNameList);

        List<String> listAllStudentName =
                stList.stream().map(Student::getName).collect(Collectors.toList());
        System.out.println(listAllStudentName);


        System.out.println(" -- Accumulate names into a TreeSet -- ");
        Set<String> studentNameTreeSetList = stList.stream().map(Student::getName).collect(Collectors.toCollection(TreeSet::new));
        System.out.println(studentNameTreeSetList);


        Map<String,List<Subject>>  studentNameSubjectMap =
                stList.stream().collect(Collectors.toMap(Student::getName,Student::getSubject));
        System.out.println(studentNameSubjectMap);


        Map<String,Long>  studentGroupNameCountingMap =
                stList.stream().collect(Collectors.groupingBy(Student::getName,Collectors.counting()));

        System.out.println(studentGroupNameCountingMap);


      List<Integer> sortedRollNoDesc =
              stList.stream().sorted((student1,student2)-> student2.getRollNo() - student1.getRollNo())
                      .map(Student::getRollNo).collect(Collectors.toList());
        System.out.println(sortedRollNoDesc); */

    }

    public static void getEmployeeListByMaxSalaryGroupByDeptUsingSorted(List<Employee> employeeList) {
        Map<String, List<Employee>> groupByDeptHasMap = employeeList.stream()
                        .sorted((e1, e2) -> Math.toIntExact(e2.getSalary()) - Math.toIntExact(e1.getSalary()))
                        .collect(
                                Collectors.groupingBy(Employee::getDept)
                        );
        List<Employee> employeesHavingMaxSalaryInRespectiveDepartment =
                groupByDeptHasMap.entrySet().stream().flatMap(str -> Stream.of(str.getValue().get(0))).collect(Collectors.toList());
        System.out.println(employeesHavingMaxSalaryInRespectiveDepartment);
    }
    public static void getEmployeeListByMaxSalaryGroupByDeptUsingMax(List<Employee> employeeList) {
        Map<String, List<Employee>> groupByDeptHasMap = employeeList.stream()
                .collect(
                        Collectors.groupingBy(Employee::getDept)
                );
        List<Employee> employeesHavingMaxSalaryInRespectiveDepartment =
                groupByDeptHasMap.entrySet().stream().flatMap(emp -> Stream.of(emp.getValue().stream().max((employee1, employee2) -> {
                    return Integer.parseInt(String.valueOf(employee1.getSalary() - employee2.getSalary()));
                }).get())).collect(Collectors.toList());
        System.out.println(employeesHavingMaxSalaryInRespectiveDepartment);
    }

    public static void getEmployeeListBySortedSalaryDescOrder(List<Employee> employeeList) {
        List<Employee> employeeListOut =
                employeeList.stream().sorted((e1, e2) -> (int) (e2.getSalary() - e1.getSalary())).
                        collect(Collectors.toList());
        System.out.println(employeeListOut);
    }
}
