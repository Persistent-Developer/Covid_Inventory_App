package com.psl.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
public class Inventory {

	@Id
	@GeneratedValue
	private int product_id;
	@NotNull
	private String product_name;
	@NotNull
	private double price;
	private int stock;
	private String product_group;
	private String category;
	private int loe_stock_indicator;
	private String in_stock;
	private String item_type;
	private String monthly_quota_per_user;
	private String yearly_quota_per_user;
	
	@ManyToMany(fetch= FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="OrderDetails",
			joinColumns = {@JoinColumn(name="fk_product_id")},
			inverseJoinColumns = {@JoinColumn (name="fk_order_id")}
			)
	private List<Orders> odList= new ArrayList<>();
	
	
	public List<Orders> getOdList() {
		return odList;
	}
	public void setOdList(List<Orders> odList) {
		this.odList = odList;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getProduct_group() {
		return product_group;
	}
	public void setProduct_group(String product_group) {
		this.product_group = product_group;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getLoe_stock_indicator() {
		return loe_stock_indicator;
	}
	public void setLoe_stock_indicator(int loe_stock_indicator) {
		this.loe_stock_indicator = loe_stock_indicator;
	}
	public String getIn_stock() {
		return in_stock;
	}
	public void setIn_stock(String in_stock) {
		this.in_stock = in_stock;
	}
	public String getItem_type() {
		return item_type;
	}
	public void setItem_type(String item_type) {
		this.item_type = item_type;
	}
	public String getMonthly_quota_per_user() {
		return monthly_quota_per_user;
	}
	public void setMonthly_quota_per_user(String monthly_quota_per_user) {
		this.monthly_quota_per_user = monthly_quota_per_user;
	}
	public String getYearly_quota_per_user() {
		return yearly_quota_per_user;
	}
	public void setYearly_quota_per_user(String yearly_quota_per_user) {
		this.yearly_quota_per_user = yearly_quota_per_user;
	}
	//constr need to add fk
	
	public Inventory() {
		super();
	}
	public Inventory(int product_id, String product_name, double price, int stock, String product_group,
			String category, int loe_stock_indicator, String in_stock, String item_type, String monthly_quota_per_user,
			String yearly_quota_per_user, List<Orders> odList) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.price = price;
		this.stock = stock;
		this.product_group = product_group;
		this.category = category;
		this.loe_stock_indicator = loe_stock_indicator;
		this.in_stock = in_stock;
		this.item_type = item_type;
		this.monthly_quota_per_user = monthly_quota_per_user;
		this.yearly_quota_per_user = yearly_quota_per_user;
		this.odList = odList;
	}
	@Override
	public String toString() {
		return "Inventory [product_id=" + product_id + ", product_name=" + product_name + ", price=" + price
				+ ", stock=" + stock + ", product_group=" + product_group + ", category=" + category
				+ ", loe_stock_indicator=" + loe_stock_indicator + ", in_stock=" + in_stock + ", item_type=" + item_type
				+ ", monthly_quota_per_user=" + monthly_quota_per_user + ", yearly_quota_per_user="
				+ yearly_quota_per_user + ", odList=" + odList + "]";
	}
	
	
	
}