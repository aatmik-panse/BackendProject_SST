package dev.aatmik.demoapi.models;

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
    private Double price;
    private String description;
    private Category category;
    private String imageUrl;
}