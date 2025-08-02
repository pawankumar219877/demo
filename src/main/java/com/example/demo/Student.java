package com.example.demo;

import java.util.Objects;

public class Student {
    long  RollNo;
    long  RegNo;
    String Name;
    String Address;
    String  ContactNo;
    String Branch;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return RollNo == student.RollNo &&
                RegNo == student.RegNo &&
                Objects.equals(Name, student.Name) &&
                Objects.equals(Address, student.Address) &&
                Objects.equals(ContactNo, student.ContactNo) &&
                Objects.equals(Branch, student.Branch);
    }

    @Override
    public int hashCode() {
        return Objects.hash(RollNo, RegNo, Name, Address, ContactNo, Branch);
    }

    public long getRollNo() {
        return RollNo;
    }

    public void setRollNo(long rollNo) {
        RollNo = rollNo;
    }

    public long getRegNo() {
        return RegNo;
    }

    public void setRegNo(long regNo) {
        RegNo = regNo;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getContactNo() {
        return ContactNo;
    }

    public void setContactNo(String contactNo) {
        ContactNo = contactNo;
    }

    public String getBranch() {
        return Branch;
    }

    public void setBranch(String branch) {
        Branch = branch;
    }

}