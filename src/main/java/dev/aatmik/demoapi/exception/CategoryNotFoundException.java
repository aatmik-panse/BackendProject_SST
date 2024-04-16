package dev.aatmik.demoapi.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryNotFoundException extends RuntimeException{
    Long id;
    public CategoryNotFoundException(Long id ,String message) {
        super(message);
        this.id = id;
    }
}
