package com.example.demo;

public class CommonBuilder<T extends Object>{
    private T object;
    private long RollNo;
    private long RegNo;
    private String Name;
    private String Address;
    private String ContactNo;
    private String Branch;

    public  CommonBuilder(T student) {
        object = student;
    }

    CommonBuilder withRollNo(final long RollNo) {
        this.RollNo = RollNo;
        return this;
    }

    CommonBuilder withRegNo(final long RegNo) {
        this.RegNo = RegNo;
        return this;
    }

    CommonBuilder withName(final String Name) {
        this.Name = Name;
        return this;
    }


    CommonBuilder withAddress(final String Address) {
        this.Address = Address;
        return this;
    }

    CommonBuilder withContactNo(final String ContactNo) {
        this.ContactNo = ContactNo;
        return this;
    }

    CommonBuilder withBranch(final String Branch) {
        this.Branch = Branch;
        return this;
    }

    public T buid() {
        return object;
    }
}
