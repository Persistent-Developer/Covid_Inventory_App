package com.psl.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class StoreHoliday {

	@Id
	private int id;
	private String holiday_name;
	private Date date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHoliday_name() {
		return holiday_name;
	}
	public void setHoliday_name(String holiday_name) {
		this.holiday_name = holiday_name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public StoreHoliday(int id, String holiday_name, Date date) {
		super();
		this.id = id;
		this.holiday_name = holiday_name;
		this.date = date;
	}
	public StoreHoliday() {
		super();
	}
	@Override
	public String toString() {
		return "StoreHoliday [id=" + id + ", holiday_name=" + holiday_name + ", date=" + date + "]";
	}
	
	
}
