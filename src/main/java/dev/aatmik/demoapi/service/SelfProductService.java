package dev.aatmik.demoapi.service;

import dev.aatmik.demoapi.exception.ProductNotFoundException;
import dev.aatmik.demoapi.models.Category;
import dev.aatmik.demoapi.models.Product;
import dev.aatmik.demoapi.repositories.CategoryRepository;
import dev.aatmik.demoapi.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
@Service
@Primary

public class SelfProductService implements ProductService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    SelfProductService(ProductRepository productRepository , CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
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
        Category category = product.getCategory();

        if(category == null){
            product.setCategory(categoryRepository.save(category));
        }
        Product product1 = productRepository.save(product);
        Optional<Category> optionalCategory = categoryRepository.findById(category.getId());
        product1.setCategory(optionalCategory.get());
        return product1;
    }

    @Override
    public void updateProduct(Long id, Product product) {

    }
}
