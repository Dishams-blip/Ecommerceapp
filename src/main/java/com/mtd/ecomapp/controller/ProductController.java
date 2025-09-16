package com.mtd.ecomapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mtd.ecomapp.entity.Product;
import com.mtd.ecomapp.service.Productservice;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private Productservice productService;
	
	@PostMapping("/save")
	public Product save(@RequestBody Product product) {
		return productService.saveProduct(product);
	}
	
	@GetMapping("/{id}")
	public Product findById(String id) {
			return productService.getProductById(id);
		}
	@GetMapping("/all")
	public List<Product> findAll(){
		return productService.getProducts();
	}
	@PutMapping("/{id}")
	public Product updateProduct(@RequestBody Product product,@PathVariable String id) {
		return productService.updateProduct(product,id);
	}
	@DeleteMapping("/{id}")
	public boolean deleteProduct(String id) {
		return productService.deleteProduct(id);
	}
}
