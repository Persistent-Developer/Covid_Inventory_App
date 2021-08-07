package com.psl.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TimeSlots {

	@Id
	private int id;
	private Date slot_date;
	private String slot_from;
	private String slot_till;
	private String no_of_orders;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getSlot_date() {
		return slot_date;
	}
	public void setSlot_date(Date slot_date) {
		this.slot_date = slot_date;
	}
	public String getSlot_from() {
		return slot_from;
	}
	public void setSlot_from(String slot_from) {
		this.slot_from = slot_from;
	}
	public String getSlot_till() {
		return slot_till;
	}
	public void setSlot_till(String slot_till) {
		this.slot_till = slot_till;
	}
	public String getNo_of_orders() {
		return no_of_orders;
	}
	public void setNo_of_orders(String no_of_orders) {
		this.no_of_orders = no_of_orders;
	}
	public TimeSlots(int id, Date slot_date, String slot_from, String slot_till, String no_of_orders) {
		super();
		this.id = id;
		this.slot_date = slot_date;
		this.slot_from = slot_from;
		this.slot_till = slot_till;
		this.no_of_orders = no_of_orders;
	}
	public TimeSlots() {
		super();
	}
	@Override
	public String toString() {
		return "TimeSlots [id=" + id + ", slot_date=" + slot_date + ", slot_from=" + slot_from + ", slot_till="
				+ slot_till + ", no_of_orders=" + no_of_orders + "]";
	}
	
	
}
