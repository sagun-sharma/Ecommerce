package test;

import java.util.Scanner;

import dbdesign.DBConnect;
import dbdesign.DBoperations;

public class ShopTest {
	public static void main(String args[]){
		int choice;
		CustomerService c =Factory.getCustomerService(new DBoperations(new DBConnect()));

		Scanner sc = new Scanner(System.in);
		do{
			System.out.println("HELOO AND WELCOME TO FLIPKART");
			System.out.println("NEW CUSTOMER??					PRESS 1");
			System.out.println("ALREADY A CUSTOMER??			PRESS 2");
			System.out.println("EXIT							PRESS 3");
			System.out.println("please enter your choice");
			choice=sc.nextInt();

			switch(choice){
			case 1 : c.signUpScreen();

			case 2 : c.signInScreen();

			}
		}while(choice!=3);
	}
}
