package test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.guavus.training.pojo.Customer;

import dbdesign.DBConnect;
import dbdesign.DBoperations;

public class CustomerService {

	DBoperations op ;

	public CustomerService(DBoperations op) {
		this.op = op;
	}

	public boolean signup(Customer customer){
		//write code to persist in db.
		try {

			String sql = "insert into customer(cid,cname,cage,cgender,caddress,userr,pwdd) values ('16', '"+ customer.getName() +"','"+ customer.getAge()+"','"+customer.getGender()+"','"+customer.getAddress()+"','"+customer.getUser()+"','"+customer.getPwd()+"')";
			System.out.println(sql);
			op.insert(sql);
			return true;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return false;

	}
	public boolean signin(String user, String password) {
		ResultSet resultSet = null;
		try {
			 resultSet = op.select("select * from customer where userr = " + user + " and pwdd = " + password);
			 System.out.println(resultSet);
			// if aNY row found return true else false
			if(resultSet!=null)
				return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//return false
		}
		
		return false;
	}



	public void signUpScreen() {
		//show signup options
		//take inpiut
		//create customer obnect
		//call Customer Service
		Scanner sc = new Scanner(System.in);
		String  name,gender,address,userr,pwd;
		int age;
		boolean temp;
		System.out.println("WELCOME TO FLIPKART SIGN UP");

		System.out.println("Enter your name");
		name=sc.next();
		System.out.println("Enter your age");
		age=sc.nextInt();
		System.out.println("Enter your gender");
		gender=sc.next();
		System.out.println("Enter your address");
		address=sc.next();
		System.out.println("Enter your user name");
		userr=sc.next();
		System.out.println("Enter your password");
		pwd=sc.next();

		Customer c = new Customer(name,age,gender,address,userr,pwd);
		temp=signup(c);
		if(temp==true){
			System.out.println("Dear customer you have successfully signed up at FlipKart");
			System.out.println("Press 1 to continue shopping");
			int input=sc.nextInt();
			if(input==1)
				ShopScreen.operations();
			else
				return;

		}
		else
			System.out.println("not signed up");
	}


	public void signInScreen() {
		//taske username password
		//		call signin methid
		// true or false
		Scanner sc = new Scanner(System.in);
		String user,pwd;
		boolean temp;
		System.out.println("WELCOME TO FLIPKART SIGN IN");
		System.out.println("enter your user name");
		user=sc.next();
		System.out.println("enter your password");
		pwd=sc.next();

		temp=signin(user,pwd);
		if(temp==true)
		{
			ShopScreen.operations();
		}
		else
			System.out.println("Please enter valid user name and password");

	}

}
