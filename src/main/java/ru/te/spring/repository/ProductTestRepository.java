package ru.te.spring.repository;

import org.springframework.stereotype.Component;
import ru.te.spring.entity.Product;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ProductTestRepository implements ProductRepository {

    private List<Product> products;

    @PostConstruct
    private void initList(){
        products = new ArrayList<>();

        products.add(new Product(1, "Test1", BigDecimal.valueOf(8700)));
        products.add(new Product(2, "Test2", BigDecimal.valueOf(28900)));
        products.add(new Product(3, "Test3", BigDecimal.valueOf(6800)));
        products.add(new Product(4, "Test4", BigDecimal.valueOf(15400)));
        products.add(new Product(5, "Test5", BigDecimal.valueOf(4200)));
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public Optional<Product> findProductByID(int id) {
        for (Product pr: products) {
            if (pr.getId() == id) return Optional.of(pr);
        }
        return Optional.empty();
    }
}