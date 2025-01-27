package com.springbootrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springbootrest.entity.Order1;
import com.springbootrest.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderservice;

	@PostMapping("/placeorder")
	public Object placeorder(@RequestParam int pid,@RequestParam int qty)  {
		return orderservice.placeorder(pid,qty);
	}
	@DeleteMapping("/cancelorder/{oid}")
	public String cancelOrder(@PathVariable int oid) {
		return orderservice.cancelorder(oid);
		
	}
}
