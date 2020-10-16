package com.example.demo;

public class StudentBuilder {
    public Student student= new Student();;
    private long RollNo;
    private long RegNo;
    private String Name;
    private String Address;
    private String ContactNo;
    private String Branch;


    public void StudentBuilder() {

    }

    StudentBuilder withRollNo(final long RollNo) {
        this.student.setRollNo(RollNo);
        return this;
    }

    StudentBuilder withRegNo(final long RegNo) {
        this.student.setRegNo(RegNo);
        return this;
    }

    StudentBuilder withName(final String Name) {
        this.student.setName(Name);
        return this;
    }


    StudentBuilder withAddress(final String Address) {
        this.student.setAddress(Address);
        return this;
    }

    StudentBuilder withContactNo(final String ContactNo) {
        student.setContactNo(ContactNo);
        return this;
    }

    StudentBuilder withBranch(final String Branch) {
        this.student.setBranch(Branch);
        return this;
    }

    public Student build() {
        return  student;
    }
}
