package com.springbootrest.service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springbootrest.entity.Product;
import com.springbootrest.repository.ProductRepository;

@Service
public class ProductService {
	private ProductRepository repository;
	public ProductService(ProductRepository repository) 
	{
		this.repository = repository;
	}
	//i want to add a new product into a table
	public Product addProduct(Product p1) 
	{
		return repository.save(p1);
	}
	//i want to read all Products
	public List<Product> viewProduct() {
		return repository.findAll();
	}
	public Optional<Product> getProductById(int id)
	{/*A container object which may or may not contain a 
	*non-null value.If a value is present, isPresent() returns true. 
	*If novalue is present, the object is considered empty and isPresent() returns false. 
	*/
		Optional<Product> p1 = repository.findById(id);
		if(p1.isPresent())
		{
			return p1;
		}
		else {
			return null;
		}
	}
	public List<Product> getProductByPrice(int price) {
		// TODO Auto-generated method stub
		return repository.getProductByPrice(price);	
	}
	public String deleteProductById(int id) {
		// TODO Auto-generated method stub
		Optional<Product> p1 = repository.findById(id);
		if(p1.isPresent()) {
			repository.deleteById(id);
			return "deleted id "+ id + " successfully";
		}else {
			return id+" is not exists in the database";
		}
	}
	public Product updateProduct(int id,Product newProduct) {
		// check product id is available 
		//if available get the product from db
		//modify the data using setters
		Optional<Product> p = repository.findById(id);
		if(p.isPresent()) 	{
			Product productFromDB = p.get();
			productFromDB.setPname(newProduct.getPname());
			productFromDB.setPrice(newProduct.getPrice());
			productFromDB.setQty(newProduct.getQty());		
			return	repository.save(productFromDB);
		}else{
			throw new RuntimeException("Invalid Product id");
		}
	}	
}