package dev.aatmik.demoapi.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreDTO {
    private Long id;
    private String title;
    private Double price;
    private String category;
    private String description;
    private String image;
}