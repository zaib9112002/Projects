package com.springbootrest.entity;

import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String pname;
	private int price;
	private int qty;
	
	@OneToMany(mappedBy = "product")
	/*creates a useless table and creates 
	 * same relation between the tables 
	 * product and order1*/
	private List<Order1> orders;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(int id, String pname, int price, int qty, List<Order1> orders) {
		super();
		this.id = id;
		this.pname = pname;
		this.price = price;
		this.qty = qty;
		this.orders = orders;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
	public List<Order1> getOrders() {
		return orders;
	}

	public void setOrders(List<Order1> orders) {
		this.orders = orders;
	}
	
}
