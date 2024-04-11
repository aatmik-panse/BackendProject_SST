package dev.aatmik.demoapi.service;

import dev.aatmik.demoapi.dtos.FakeStoreProductDTO;
import dev.aatmik.demoapi.models.Category;
import dev.aatmik.demoapi.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;

@Service
public class FakeStoreProductService implements ProductService{
    @Override
    public Product getProductById(Long id){

        RestTemplate restTemplate = new RestTemplate(); // RestTemplate helps in making HTTP requests
        //call the fake store api to get the product by id
        FakeStoreProductDTO fakeStoreProductDTO = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDTO.class);
        if(fakeStoreProductDTO == null){
            return null;
        }

        return convertFakeStoreProductDTOToProduct(fakeStoreProductDTO);
    }
    @Override
    public ArrayList<Product> getAllProducts(){
        RestTemplate restTemplate = new RestTemplate();

        // making HTTP request to the fake store api to get all products
        FakeStoreProductDTO[] fakeStoreProductDTOS = restTemplate.getForObject("https://fakestoreapi.com/products",
                FakeStoreProductDTO[].class);

        ArrayList<Product> products = new ArrayList<>();

        assert fakeStoreProductDTOS != null;
        for(FakeStoreProductDTO fakeStoreProductDTO: fakeStoreProductDTOS){
            products.add(convertFakeStoreProductDTOToProduct(fakeStoreProductDTO));
        }

        return products;
    }
    @Override
    public void createProduct(Product product) {
        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO.setId(product.getId());
        fakeStoreProductDTO.setTitle(product.getTitle());
        fakeStoreProductDTO.setDescription(product.getDescription());
        fakeStoreProductDTO.setPrice(product.getPrice());
        fakeStoreProductDTO.setImage(product.getImageUrl());
    }
    @Override
    public void updateProduct(Long id, Product product) {
        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO.setId(product.getId());
        fakeStoreProductDTO.setTitle(product.getTitle());
        fakeStoreProductDTO.setDescription(product.getDescription());
        fakeStoreProductDTO.setPrice(product.getPrice());
        fakeStoreProductDTO.setImage(product.getImageUrl());

    }

    private Product convertFakeStoreProductDTOToProduct(FakeStoreProductDTO fakeStoreProductDTO){
        //there can be some attributes in fake store which we don't have in our Product, so we need to map them

        Product product = new Product();
        product.setId(fakeStoreProductDTO.getId());
        product.setTitle(fakeStoreProductDTO.getTitle());
        product.setDescription(fakeStoreProductDTO.getDescription());
        product.setPrice(fakeStoreProductDTO.getPrice());
        product.setImageUrl(fakeStoreProductDTO.getImage());
        Category category = new Category();
        category.setDescription(fakeStoreProductDTO.getCategory());
        product.setCategory(category);
        return product;
    }

}