package com.mtd.ecomapp.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtd.ecomapp.entity.Product;
import com.mtd.ecomapp.repository.ProductRepository;

@Service
public class Productservice {
	
	@Autowired
	private ProductRepository productRepository;
	
	//save
	public Product saveProduct(Product product) {
		product.setId(null);
		return productRepository.save(product);
	}
	//getbyid
	public Product getProductById(String id) {
		return productRepository.findById(id).get();
	}
	
	public List<Product> getProducts(){
		return productRepository.findAll();
	}
	//deleteprduct
	public boolean deleteProduct(String id){
		Optional<Product> product = productRepository.findById(id);
		if(product.isEmpty()) {
			return false;
		}
		productRepository.deleteById(id);
		return true;
	}
	public Product updateProduct(Product product,String id) {
		Product existingProduct = 	productRepository.findById(id).get();
		
		existingProduct.setName(product.getName());
		existingProduct.setDescription(product.getDescription());
		existingProduct.setCategory(product.getCategory());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setTags(product.getTags());
		existingProduct.setStock(product.getStock());
		
		return productRepository.save(existingProduct);
	}
}
