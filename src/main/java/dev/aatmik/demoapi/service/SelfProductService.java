package dev.aatmik.demoapi.service;

import dev.aatmik.demoapi.exception.ProductNotFoundException;
import dev.aatmik.demoapi.models.Product;
import dev.aatmik.demoapi.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
@Service
@Primary

public class SelfProductService implements ProductService{

    private ProductRepository productRepository;
    SelfProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    @Override
    public Product getProductById(Long id) {
        Optional<Product>  optionalProduct = productRepository.findById(id);
        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException(id,"Product not found");
        }

        return optionalProduct.get();
    }

    @Override
    public ArrayList<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void updateProduct(Long id, Product product) {

    }
}
