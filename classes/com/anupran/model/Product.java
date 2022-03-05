package com.anupran.model;

public class Product {
	int prod_c_id,prod_id;
	String prod_name,prod_desc,image;
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getProd_c_id() {
		return prod_c_id;
	}
	public void setProd_c_id(int prod_c_id) {
		this.prod_c_id = prod_c_id;
	}
	public int getProd_id() {
		return prod_id;
	}
	public void setProd_id(int prod_id) {
		this.prod_id = prod_id;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public String getProd_desc() {
		return prod_desc;
	}
	public void setProd_desc(String prod_desc) {
		this.prod_desc = prod_desc;
	}
	
}
