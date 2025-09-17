package com.mtd.ecomapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mtd.ecomapp.entity.Product;
import com.mtd.ecomapp.service.Productservice;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final Productservice productService;

    // ✅ Constructor Injection (recommended instead of @Autowired)
    public ProductController(Productservice productService) {
        this.productService = productService;
    }

    // ✅ Create Product
    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product product) {
        Product saved = productService.saveProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // ✅ Get Product by ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable String id) {
        Product product = productService.getProductById(id);
        return product != null ? ResponseEntity.ok(product) : ResponseEntity.notFound().build();
    }

    // ✅ Get All Products
    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(productService.getProducts());
    }

    // ✅ Update Product
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable String id) {
        Product updated = productService.updateProduct(product, id);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    // ✅ Delete Product
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        boolean deleted = productService.deleteProduct(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
