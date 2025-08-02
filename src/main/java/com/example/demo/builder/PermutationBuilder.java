package com.example.demo.builder;

import com.example.demo.model.PermutationModel;

public class PermutationBuilder {
    private long id;
    private PermutationModel permutation;
    private String perrmutes;

    public PermutationBuilder(){
        permutation = new PermutationModel();
    }
    public  PermutationBuilder withId(long id){
        this.id=id;
        return this;
    }

    public  PermutationBuilder withPerrmutes(String perrmutes){
        this.perrmutes=perrmutes;
        return this;
    }

    public PermutationModel build(){
        return permutation;
    }

}
