package org.example.test_st10.controller;

import org.example.test_st10.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @GetMapping("/api/products/all")
    public List<Product> getProducts() {
        return List.of(
               new Product(1,"Apple", 1000, "Fresh and juicy apples"),
                new Product(2,"Banana", 500, "Sweet and ripe bananas"),
                new Product(3,"Orange", 800, "Citrusy and refreshing oranges"),
                new Product(4,"Mango", 1200, "Tropical and delicious mangoes")

        );
    }
}
