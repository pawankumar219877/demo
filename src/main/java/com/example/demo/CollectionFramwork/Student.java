package com.example.demo.CollectionFramwork;

import java.util.Objects;

public class Student {
    // Attributes of a student
    public int rollno;
    public  String name, address;

    public int getRollno() {
        return rollno;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    // Constructor
    public Student(int rollno, String name, String address)
    {
        // This keyword refers to current object itself
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }

    // Method of this class
    // To print student details
    public String toString()
    {
        return this.rollno + " " + this.name + " "
                + this.address;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rollno, name, address);
    }

//    @Override
//    public int hashCode() {
//        // Use a prime number (e.g., 31) for better distribution
//        int result = 31;
//        result = 31 * result + rollno;
//        return result;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return rollno == student.rollno;
    }
}
