package com.example.demo.asynPackage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private Long id;
    private Long stockId;
    private Integer quantity;
    private Double price;
}
