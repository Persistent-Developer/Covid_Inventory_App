package com.psl.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Store {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String is_active;
	private int no_of_timeslots;
	private int slot_duration;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIs_active() {
		return is_active;
	}
	public void setIs_active(String is_active) {
		this.is_active = is_active;
	}
	public int getNo_of_timeslots() {
		return no_of_timeslots;
	}
	public void setNo_of_timeslots(int no_of_timeslots) {
		this.no_of_timeslots = no_of_timeslots;
	}
	public int getSlot_duration() {
		return slot_duration;
	}
	public void setSlot_duration(int slot_duration) {
		this.slot_duration = slot_duration;
	}
	public Store(int id, String name, String is_active, int no_of_timeslots, int slot_duration) {
		super();
		this.id = id;
		this.name = name;
		this.is_active = is_active;
		this.no_of_timeslots = no_of_timeslots;
		this.slot_duration = slot_duration;
	}
	public Store() {
		super();
	}
	@Override
	public String toString() {
		return "Store [id=" + id + ", name=" + name + ", is_active=" + is_active + ", no_of_timeslots="
				+ no_of_timeslots + ", slot_duration=" + slot_duration + "]";
	}
	
	
}
