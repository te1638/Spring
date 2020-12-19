package ru.te.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.te.spring.entity.Product;
import ru.te.spring.service.ProductService;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
@Scope(scopeName = "prototype")
public class Cart {

    private final ProductService productService;

    private Map<Product, Integer> productMap;

    @Autowired
    public Cart(ProductService productService) {
        this.productService = productService;
    }

    @PostConstruct
    private void initEmptyCart(){
        productMap = new HashMap<>();
    }

    public Map<Product, Integer> getProductMap(){
        return productMap;
    }

    public boolean addProductByProductID(int productID){
        var product = productService.getProductByID(productID);
        if (product.isEmpty()) return false;

        productMap.computeIfPresent(product.get(), (key, oldValue) -> {return oldValue + 1;});
        productMap.putIfAbsent(product.get(), 1);
        return true;
    }

    public boolean removeProductByProductID(int productID){
        var product = productService.getProductByID(productID);
        if (product.isEmpty()) return false;

        productMap.computeIfPresent(product.get(), (key, oldValue) -> {return oldValue - 1;});
        productMap.remove(product.get(), 0);

        return true;
    }


}