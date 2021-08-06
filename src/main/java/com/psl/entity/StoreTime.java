package com.psl.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class StoreTime {

	@Id
	@GeneratedValue
	private int id;
	private String day;
	private String start_time;
	private String end_time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public StoreTime(int id, String day, String start_time, String end_time) {
		super();
		this.id = id;
		this.day = day;
		this.start_time = start_time;
		this.end_time = end_time;
	}
	public StoreTime() {
		super();
	}
	@Override
	public String toString() {
		return "StoreTime [id=" + id + ", day=" + day + ", start_time=" + start_time + ", end_time=" + end_time + "]";
	}
	
	
}



