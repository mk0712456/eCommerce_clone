package com.example.Model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseModel {
    private String title;
    private double price;
    private Category category;
}
