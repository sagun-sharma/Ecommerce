package com.guavus.training.pojo;

public class Catalogue {
	int producttype;
	int size;
	String  brand;
	int price;
	String extra;
	public Catalogue(int producttype, int size,int price, String brand,String extra) {
		this.producttype = producttype;
		this.size = size;
		this.price = price;
		this.brand = brand;
		this.extra=extra;

	}
	public int getProductType() {
		return producttype;
	}
	public int getSize() {
		return size;
	}
	public int getPrice() {
		return price;
	}
	public String getbrand() {
		return brand;
	}
	public String getextra() {
		return extra;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.valueOf(producttype) +(size)+(price)+(brand)+(extra);
	}

}
