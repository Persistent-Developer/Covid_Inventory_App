package com.psl.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int order_details_id;
	
	private double total_quantities;
	private int quantity;
	public double getTotal_quantities() {
		return total_quantities;
	}
	public void setTotal_quantities(double total_quantities) {
		this.total_quantities = total_quantities;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public OrderDetails(double total_quantities, int quantity) {
		
		this.total_quantities = total_quantities;
		this.quantity = quantity;
	}
	public OrderDetails() {
		
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "OrderDetails [total_quantities=" + total_quantities + ", quantity=" + quantity + "]";
	}
	
	
	
}
