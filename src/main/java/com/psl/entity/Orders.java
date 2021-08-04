package com.psl.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int order_id;
	private String order_status;
	private String delivery_date;
	private String time_slot_start;
	private String time_slot_end;
	private String contact;
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getdelivery_date() {
		return delivery_date;
	}
	public void setDelivery_date(String delivery_date) {
		this.delivery_date = delivery_date;
	}
	public String getTime_slot_start() {
		return time_slot_start;
	}
	public void setTime_slot_start(String time_slot_start) {
		this.time_slot_start = time_slot_start;
	}
	public String getTime_slot_end() {
		return time_slot_end;
	}
	public void setTime_slot_end(String time_slot_end) {
		this.time_slot_end = time_slot_end;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	public Orders(int order_id, String delivery_date, String time_slot_start, String time_slot_end, String contact,
			String order_status) {
		
		this.order_id = order_id;
		this.delivery_date = delivery_date;
		this.time_slot_start = time_slot_start;
		this.time_slot_end = time_slot_end;
		this.contact = contact;
		this.order_status = order_status;
	}
	public Orders() {
		
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", delivery_date=" + delivery_date + ", time_slot_start="
				+ time_slot_start + ", time_slot_end=" + time_slot_end + ", contact=" + contact + ", order_status="
				+ order_status + "]";
	}

}
