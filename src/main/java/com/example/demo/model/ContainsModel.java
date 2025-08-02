package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ContainsModel {
    String name;
    Integer rollNo;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        ContainsModel other = (ContainsModel) obj;
        return this.getRollNo().equals(other.getRollNo())
                && this.rollNo == other.rollNo;
    }
}
