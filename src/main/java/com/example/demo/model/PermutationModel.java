package com.example.demo.model;

public class PermutationModel {
  private long id;
  private String perrmutes;

    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }

    public String getPerrmutes() {
        return perrmutes;
    }

    public void setPerrmutes(String perrmutes) {
        this.perrmutes = perrmutes;
    }

    @Override
    public String toString() {
        return "Permutation=id"+this.getId()+"Perrmutes="+ this.getPerrmutes();
    }

}
