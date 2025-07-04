package org.example.test_st10.controller;

import org.example.test_st10.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @GetMapping("/all")
    public List<Product> getProducts() {
        return List.of(
               new Product(1,"Apple", 1000, "Fresh and juicy apples"),
                new Product(2,"Banana", 500, "Sweet and ripe bananas"),
                new Product(3,"Orange", 800, "Citrusy and refreshing oranges"),
                new Product(4,"Mango", 1200, "Tropical and delicious mangoes")

        );
    }
    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable int id) {
        return getProducts().stream()
                .filter(product -> product.id() == id)
                .findFirst();
    }


    public record Product(int id, String name, int price, String description) {}
}
