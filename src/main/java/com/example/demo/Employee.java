package com.example.demo;

import java.util.List;

public class Employee {

   private String name;

   private  String emailId;

   private  Long id;

   private List<Group> groupList;

   private  Department department;

   /**
    * Get Name
    * @return name
    */
   public String getName() {
      return name;
   }

   /**
    * Set Name
    * @param name the Name
    */
   public void setName(String name) {
      this.name = name;
   }

   public String getEmailId() {
      return emailId;
   }

   public void setEmailId(String emailId) {
      this.emailId = emailId;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public List<Group> getGroupList() {
      return groupList;
   }

   public void setGroupList(List<Group> groupList) {
      this.groupList = groupList;
   }

   public Department getDepartment() {
      return department;
   }

   public void setDepartment(Department department) {
      this.department = department;
   }

   @Override
   public String toString() {
      return "Employee{" +
              "name='" + name + '\'' +
              ", emailId='" + emailId + '\'' +
              ", id=" + id +
              ", groupList=" + groupList +
              ", department=" + department +
              '}';
   }
}
