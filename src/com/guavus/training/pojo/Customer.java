package com.guavus.training.pojo;

public class Customer {
	
	String  name;
	String gender;
	String  address;
	int age;
	String user,pwd;
	public Customer(String name , int age, String gender, String address,String user,String pwd) {
		
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		
		this.user=user;
		this.pwd=pwd;
	}
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getGender() {
		return gender;
	}
	public String getAddress() {
		return address;
	}
	
	public String getUser() {
		return user;
	}

	public String getPwd() {
		return pwd;
	}


}
