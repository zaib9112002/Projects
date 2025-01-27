package com.springbootrest.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootrest.entity.Product;
import com.springbootrest.service.ProductService;

@RestController
@RequestMapping("/product")
	//@RequestMapping is used to map the url like 
	//(http://localhost:8080/)
public class ProductController {
		private ProductService service;
	
	public ProductController(ProductService service) {}	
	/* 1.@PostMapping - used to insert the row in the table
	 * 2.@GetMapping - used to read the row from table
	 * 3.@PutMapping - used to update the row
	 * 4.@DeleteMApping - used to delete the row
	 * 5.@RequestBody - used to send the data from client to service
	 * 6.@Path Variable - used to send data through 
	 * the url path from client to service
	 */
	
	@PostMapping("/addproduct")
	public ResponseEntity<Product> addProduct(@RequestBody Product p1)
	{
		Product p = service.addProduct(p1);
		return ResponseEntity.ok(p);
	}
	@GetMapping("/viewproduct")
	public List<Product> viewProduct() 
	{
		return service.viewProduct();
	}
	@GetMapping("/getproductbyid/{id}")
	public Optional<Product> getProductById(@PathVariable int id)
	{
		return service.getProductById(id);
	}
	@GetMapping("/getproductbyprice/{price}")
	public ResponseEntity<List<Product>> getProductByPrice(@PathVariable int price)
	{
		return new ResponseEntity<>(service.getProductByPrice(price),HttpStatus.FOUND);
	}//ReponseEntity is used to return the response along with the 
	/*Http Status. OK
	*HttpStatus.Found
	*/
	@DeleteMapping("/deleteProductById/{id}")
	public String deleteProductById(@PathVariable int id)
	{
		return service.deleteProductById(id);
		 
	}
	@PutMapping("/updateProduct/{id}")
	public Product updateProduct(@PathVariable int id,@RequestBody Product newProduct) {
		return service.updateProduct(id,newProduct);
	}
}