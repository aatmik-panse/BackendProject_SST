package dev.aatmik.demoapi.controllers;

import dev.aatmik.demoapi.dtos.FakeStoreProductDTO;
import dev.aatmik.demoapi.models.Product;
import dev.aatmik.demoapi.service.FakeStoreProductService;
import dev.aatmik.demoapi.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

//RestController signifies this controller will handle HTTP requests APIs
//RequestMapping specifies the base URL for the controller
@RestController
@RequestMapping("/products")
public class ProductController { // waiter
    //Classes should be public as they are accessed from outside the package
    //Methods should be public as they are accessed from outside the class
    //Methods should be annotated with @GetMapping, @PostMapping, @PutMapping, @PatchMapping, or @DeleteMapping
    //Methods should have a return type
    //Methods should have a meaningful name
    //Methods should have a meaningful parameter name

    private ProductService productService;
    ProductController(ProductService productService){
        this.productService=productService;
    }

    //GetMapping specifies the URL for the method
    @GetMapping("/hello")
    public String sayHello() {
        return ":)";
    }
    //There are 2 methods of calling a endpoint  1./products/get/id 2./products/1 2nd as per RESTful API
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {

//        throw new RuntimeException("Not implemented By Aatmik");
        ResponseEntity<Product> responseEntity = null;
        Product product = null;
        try {
            product = productService.getProductById(id);
            responseEntity = new ResponseEntity<>(product, HttpStatus.NOT_FOUND);
            System.out.println("got product by id");
            return responseEntity;
        } catch (RuntimeException exception) {
            Object dto;
            if (product == null) {
                dto = new FakeStoreProductDTO();
            } else {
                dto = product;
            }
            new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
    @GetMapping("/get/{id}")
    public Product getProductById2(@PathVariable("id") Long id) {
        try {
            return productService.getProductById(id);

        }catch (Exception e){
            throw new RuntimeException("Not implemented By Aatmik");
        }
//        return  productService.getProductById(id);
    }
    @GetMapping("")
    public ArrayList<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("")
    public void createProduct(Product product){
        productService.createProduct(product);
    }

}