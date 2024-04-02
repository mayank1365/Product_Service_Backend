package com.mayank.product_service_sst.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor



public class Product {

    private Long id;
    private String title;
    private String description;
    private Double price;
    private Long category;
    private String image;

}
