package com.example.demo.JavaStream;

public class Subject {
    public String subjectName;
    public String subjectDesc;

    public String getSubjectName() {
        return subjectName;
    }

    public Subject(String subjectName, String subjectDesc) {
        this.subjectName = subjectName;
        this.subjectDesc = subjectDesc;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectDesc() {
        return subjectDesc;
    }

    public void setSubjectDesc(String subjecDesc) {
        this.subjectDesc = subjecDesc;
    }
}
