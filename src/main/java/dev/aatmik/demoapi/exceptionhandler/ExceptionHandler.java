package dev.aatmik.demoapi.exceptionhandler;

import dev.aatmik.demoapi.dtos.ExcDto;
import dev.aatmik.demoapi.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
//    @org.springframework.web.bind.annotation.ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<ExcDto> handleException(RuntimeException exception) {
//        ExcDto dto = new ExcDto();
//        dto.setDetails("No Product Found");
//        dto.setMessage("Something went wrong");
//        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
//    }

//    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
//    public ResponseEntity<ExcDto> handleGeneralException(Exception exception) {
//        ExcDto dto = new ExcDto();
//        dto.setDetails("Exception");
//        dto.setMessage("Something went wrong");
//        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
//    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExcDto> handleArithmeticException(ArithmeticException exception) {
        ExcDto dto = new ExcDto();
        dto.setDetails("Arithmetic Exception");
        dto.setMessage("Something went wrong");
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExcDto> handleProductNotFoundException(ProductNotFoundException exception) {

        ExcDto dto = new ExcDto();
        dto.setDetails("Product with id "+exception.getId()+" Not Found");
        dto.setMessage("Please enter a valid product id");
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);

    }
}
