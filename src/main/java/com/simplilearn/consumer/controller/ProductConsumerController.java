package com.simplilearn.consumer.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.simplilearn.consumer.model.Product;

@RestController
@RequestMapping("/api/consumer")
public class ProductConsumerController {

	String url = "http://localhost:9000/api/products/";

	@GetMapping("/products/{id}")
	public Product fetchProduct(@PathVariable("id") int id) {
		// step1 : use rest template
		RestTemplate restTemplate = new RestTemplate();
		// step2 : consume endpoint url
		ResponseEntity<Product> product = restTemplate.getForEntity(url + id, Product.class);
		return product.getBody();
	}

	@GetMapping("/products")
	public List fetchAllProduct() {
		// step1 : use rest template
		RestTemplate restTemplate = new RestTemplate();
		// step2 : consume endpoint url
		ResponseEntity<List> product = restTemplate.getForEntity(url, List.class);
		return product.getBody();
	}
	
	@PutMapping("/products")
	public String updateProduct(@RequestBody Product product) {
		// step1 : use rest template
		RestTemplate restTemplate = new RestTemplate();
		// step2 : consume endpoint url
		 restTemplate.put(url+product.getId(), product);
		return "Product is updated successfully !";
	}
	
	@DeleteMapping("/products/{id}")
	public String deleteProduct(@PathVariable("id") int id) {
		// step1 : use rest template
		RestTemplate restTemplate = new RestTemplate();
		// step2 : consume endpoint url
		restTemplate.delete(url + id);
		return "Product is deleted successfully !";
	}

}
