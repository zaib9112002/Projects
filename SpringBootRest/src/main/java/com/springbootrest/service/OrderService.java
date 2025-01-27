package com.springbootrest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.springbootrest.entity.*;
import com.springbootrest.repository.OrderRepository;
import com.springbootrest.repository.ProductRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderrepository;
	@Autowired
	private ProductRepository productrepository;
	
	public ResponseEntity<OrderWrapper> placeorder(int pid, int qty) {
		// TODO Auto-generated method stub
		//check product is available
		Optional<Product> p1 = productrepository.findById(pid);
		if(p1.isPresent()) {
			//check the quantity in product
			Product p = p1.get();
			if(p.getQty() >= qty) {
				//create a new order and set the values
				//product,qty,total price,status
				Order1 o = new Order1();
				o.setProduct(p);
				o.setQty(qty);
				o.setStatus("Placed");
				o.setTotalprice(p.getPrice()*qty);
				p.setQty(p.getQty() - qty);
				
				orderrepository.save(o);
				OrderWrapper ow = new OrderWrapper(o.getOid(),o.getTotalprice(),o.getQty(),o.getStatus(),o.getProduct().getPname());
				
				return ResponseEntity.ok(ow);
			}else {
			throw new RuntimeException("stock Unavailable");
			}
		}else {
			throw new RuntimeException("Product is not Available");
		}
		
	}

	public String cancelorder(int oid) {
		Optional<Order1> existingOrder = orderrepository.findById(oid);
		if(existingOrder.isPresent()) 
		{
			Product p =existingOrder.get().getProduct();
			p.setQty(p.getQty()+existingOrder.get().getQty());
			productrepository.save(p);
			orderrepository.deleteById(oid);
			return "Order Cancelled Successfully";
		}
		else
		{			
			return "Invalid Order Id";
		}
	}
}
