package dev.aatmik.demoapi.service;

import dev.aatmik.demoapi.exception.CategoryNotFoundException;
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
@Primary // instead  of using @Primary we can use @Qualifier to specify which implementation to use
         //in @qualifier we have to specify the name of the implementation as @Service("selfProductService") and in the controller we have to use @Qualifier("selfProductService")

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
        return (ArrayList<Product>) productRepository.findAll(); //findAll() is a method of JpaRepository which returns a list of all the products
    }

    @Override

    public Product createProduct(Product product) {
        Category category = product.getCategory();

        if(category == null){
            product.setCategory(categoryRepository.save(category));
        }
        Product product1 = productRepository.save(product);
        Optional<Category> optionalCategory = categoryRepository.findById(category.getId());
        if(optionalCategory.isEmpty()){
            throw new CategoryNotFoundException(category.getId(),"Category not found");
        }
        product1.setCategory(optionalCategory.get());
        return product1;
    }

    @Override
    public void updateProduct(Long id, Product product) {

    }
}
