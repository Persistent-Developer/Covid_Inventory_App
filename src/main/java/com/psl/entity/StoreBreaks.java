package com.psl.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class StoreBreaks {

	@Id
	@GeneratedValue
	private int id;
	private String break_from;
	private String break_to;
	private String break_type;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBreak_from() {
		return break_from;
	}
	public void setBreak_from(String break_from) {
		this.break_from = break_from;
	}
	public String getBreak_to() {
		return break_to;
	}
	public void setBreak_to(String break_to) {
		this.break_to = break_to;
	}
	public String getBreak_type() {
		return break_type;
	}
	public void setBreak_type(String break_type) {
		this.break_type = break_type;
	}
	public StoreBreaks(int id, String break_from, String break_to, String break_type) {
		super();
		this.id = id;
		this.break_from = break_from;
		this.break_to = break_to;
		this.break_type = break_type;
	}
	public StoreBreaks() {
		super();
	}
	@Override
	public String toString() {
		return "StoreBreaks [id=" + id + ", break_from=" + break_from + ", break_to=" + break_to + ", break_type="
				+ break_type + "]";
	}
	
	
}
