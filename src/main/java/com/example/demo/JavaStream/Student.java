package com.example.demo.JavaStream;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Student {

    public String name;
    public Integer rollNo;

    public List<Subject> subject;

    public Student(String name, Integer rollNo, List<Subject> subject) {
        this.name = name;
        this.rollNo = rollNo;
        this.subject = subject;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRollNo() {
        return rollNo;
    }

    public void setRollNo(Integer rollNo) {
        this.rollNo = rollNo;
    }

    public List<Subject> getSubject() {
        return subject;
    }

    public void setSubject(List<Subject> subject) {
        this.subject = subject;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rollNo, subject);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj==null || obj.getClass()!=getClass()) {
            return false;
        }
        return ((Student) obj).getRollNo() == this.getRollNo();
    }
}
