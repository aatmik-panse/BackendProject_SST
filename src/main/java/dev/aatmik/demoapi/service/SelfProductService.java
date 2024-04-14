package dev.aatmik.demoapi.service;

import dev.aatmik.demoapi.models.Product;
import dev.aatmik.demoapi.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.Optional;

public class SelfProductService implements ProductService{

    private ProductRepository productRepository;
    SelfProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    @Override
    public Product getProductById(Long id) {
        Optional<Product>  optionalProduct = productRepository.findById(id);
        Product product = optionalProduct.get();
        product.getDescription();
        return null;
    }

    @Override
    public ArrayList<Product> getAllProducts() {
        return null;
    }

    @Override
    public void createProduct(Product product) {

    }

    @Override
    public void updateProduct(Long id, Product product) {

    }
}
