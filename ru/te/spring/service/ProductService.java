package ru.te.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.te.spring.repository.ProductRepository;
import ru.te.spring.entity.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class ProductService {

    private ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return Collections.unmodifiableList(productRepository.getProducts());
    }

    public List<Product> getNewEmptyProductList(){
        return new ArrayList<Product>();
    }

    public Optional<Product> getProductByID(int id){
        return productRepository.findProductByID(id);
    }

}