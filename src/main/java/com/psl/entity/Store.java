package com.psl.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Store {
	
	@Id
	private int id;
	private String name;
	private String is_active;
	private int no_of_timeslots;
	private int slot_duration;
	
	@OneToMany(targetEntity = StoreBreaks.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="fk1_storeid",referencedColumnName = "id")
	private List<StoreBreaks> sblist;
	
	@OneToMany(targetEntity = StoreHoliday.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="fk2_storeid",referencedColumnName = "id")
	private List<StoreHoliday> shlist;
	
	@OneToMany(targetEntity = StoreTime.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="fk3_storeid",referencedColumnName = "id")
	private List<StoreTime> stlist;
	
	@OneToMany(targetEntity = TimeSlots.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="fk4_storeid",referencedColumnName = "id")
	private List<TimeSlots> tslist;
	
	
	
	public Store() {
		super();
	}
	
	public Store(int id, String name, String is_active, int no_of_timeslots, int slot_duration,
			List<StoreBreaks> sblist, List<StoreHoliday> shlist, List<StoreTime> stlist, List<TimeSlots> tslist, List<Inventory> ilist) {
		super();
		this.id = id;
		this.name = name;
		this.is_active = is_active;
		this.no_of_timeslots = no_of_timeslots;
		this.slot_duration = slot_duration;
		this.sblist = sblist;
		this.shlist = shlist;
		this.stlist = stlist;
		this.tslist = tslist;
	}

	public List<StoreBreaks> getSblist() {
		return sblist;
	}
	public void setSblist(List<StoreBreaks> sblist) {
		this.sblist = sblist;
	}
	public List<StoreHoliday> getShlist() {
		return shlist;
	}
	public void setShlist(List<StoreHoliday> shlist) {
		this.shlist = shlist;
	}
	public List<StoreTime> getStlist() {
		return stlist;
	}
	public void setStlist(List<StoreTime> stlist) {
		this.stlist = stlist;
	}
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
	

	public List<TimeSlots> getTslist() {
		return tslist;
	}

	public void setTslist(List<TimeSlots> tslist) {
		this.tslist = tslist;
	}


	@Override
	public String toString() {
		return "Store [id=" + id + ", name=" + name + ", is_active=" + is_active + ", no_of_timeslots="
				+ no_of_timeslots + ", slot_duration=" + slot_duration + ", sblist=" + sblist + ", shlist=" + shlist 
				+ ", stlist=" + stlist + ", tslist=" + tslist + "]";
	}
	
	

	
	
}
