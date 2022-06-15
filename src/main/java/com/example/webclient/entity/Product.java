package com.example.webclient.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;


}
