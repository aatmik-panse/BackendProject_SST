package dev.aatmik.demoapi.service;

import dev.aatmik.demoapi.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface ProductService {
    Product getProductById(Long id);
    ArrayList<Product> getAllProducts();
    Product createProduct(Product product);
    void updateProduct(Long id, Product product);
}
