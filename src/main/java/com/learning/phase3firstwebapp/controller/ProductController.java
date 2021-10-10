package com.learning.phase3firstwebapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learning.phase3firstwebapp.entity.Product;

@RestController
@RequestMapping("/api")
public class ProductController 
{
	 List<Product> products = new ArrayList<>();
	 	
	 //get one product 
		@GetMapping("/products/{id}")
		public Product getProducts(@PathVariable("id")long id)
		{
			//for loop to iterate through each item 
			for (Product product : products) {
				if(product.getId()==id)
				{
					return product ; 
				}
			}
			return null;
			//if the list of product is available it will return the list of products 	
		}	 
	 //list all product 
		@GetMapping("/products")
		public List<Product>getProduct()
		{
			return products;
			//if the list of product is available it will return the list of products 	
		}
	// create product 
		//post request to create a data / product 
		@PostMapping("/products")
		public Product addProduct (@RequestBody Product productObj)
		{
			products.add(productObj);
			return productObj;
		}
		
		// update product
		//post request to create a data / product 
		@PutMapping("/products")//put request is an update request generally  
		//we put id to ensure we update a specific product only 
		public Product updateProduct(@RequestBody Product productObj) 	
		{
			for(int index=0 ; index<products.size();index++)
			{
				if(products.get(index).getId()==productObj.getId())
				{
					products.set(index, productObj);
				}
			}
			return null;
		}
		

		// get on product
		@DeleteMapping("/products/{id}")
		public Product deleteProduct(@PathVariable("id") long id) 
		{
			for (int index = 0 ; index <products.size() ; index++)
			{
				if(products.get(index).getId()==id)
				{
					products.remove(index);
				}
			}
			return null ; 
		}
}
