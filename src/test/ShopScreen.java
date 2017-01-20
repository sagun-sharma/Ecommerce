package test;

import java.util.Scanner;

import dbdesign.DBConnect;
import dbdesign.DBoperations;

public class ShopScreen {
	static Scanner sc = new Scanner(System.in);

	public static void operations(){

		int choice;
		do{
			System.out.println("Do you want to shop? 	PRESS 1");
			System.out.println("Exit					PRESS 2");
			System.out.println("please enter your choice");
			choice=sc.nextInt();

			if(choice==1){

				System.out.println("You have following three options :");
				System.out.println("CLOTHES 1 \t SHOES 2 \t BAGS 3");
				System.out.println("Enter your option");
				int productType = sc.nextInt();
				ShoppingService.showProductScreen(productType);;
			}
			else 
				break;
		}while(choice!=2);

	}
	public static void takeorder(){
		boolean temp;
		PaymentService ps =Factory.getPaymentService(new DBoperations(new DBConnect()));
		ShoppingService ss =Factory.getShoppingService(new DBoperations(new DBConnect()));
		OrderService o = Factory.getOrderService(new DBoperations(new DBConnect()));
		PaymentScreen pps = new PaymentScreen(ps, ss);
		System.out.println("Do you want to place an order??");
		System.out.println("YES		1");
		System.out.println("NO		2");
		System.out.println("Enter your choice");
		int choice = sc.nextInt();
		if(choice==1)
		{	System.out.println("enter the unique product id of the product you wish to buy");
		String id = sc.next();
		temp=o.insertorder(id);
		if(temp==true)
			pps.askUser();
		}
		if(choice==2)
			operations();

	}
}
