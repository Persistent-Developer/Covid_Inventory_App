package com.psl.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	private int userId;
	
	private String userName;
	private long phNumber;
	private String password;
	private String email;
	private String status;
	private String category;
	private int purchaseLimitPerYear;
	private int purchaseLimitPerMonth;
	
	
	
	public User() {
		super();
	}



	public User(int userId, String userName, long phNumber, String password, String email, String status,
			String category, int purchaseLimitPerYear, int purchaseLimitPerMonth) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.phNumber = phNumber;
		this.password = password;
		this.email = email;
		this.status = status;
		this.category = category;
		this.purchaseLimitPerYear = purchaseLimitPerYear;
		this.purchaseLimitPerMonth = purchaseLimitPerMonth;
	}
	
	
	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public long getPhNumber() {
		return phNumber;
	}



	public void setPhNumber(long phNumber) {
		this.phNumber = phNumber;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public int getPurchaseLimitPerYear() {
		return purchaseLimitPerYear;
	}



	public void setPurchaseLimitPerYear(int purchaseLimitPerYear) {
		this.purchaseLimitPerYear = purchaseLimitPerYear;
	}



	public int getPurchaseLimitPerMonth() {
		return purchaseLimitPerMonth;
	}



	public void setPurchaseLimitPerMonth(int purchaseLimitPerMonth) {
		this.purchaseLimitPerMonth = purchaseLimitPerMonth;
	}



	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", phNumber=" + phNumber + ", password=" + password
				+ ", email=" + email + ", status=" + status + ", category=" + category + ", purchaseLimitPerYear="
				+ purchaseLimitPerYear + ", purchaseLimitPerMonth=" + purchaseLimitPerMonth + "]";
	}

}
