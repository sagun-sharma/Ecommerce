package test;

import java.util.Scanner;

public class PaymentScreen {
	//proceed for payment
	PaymentService p;
	ShopScreen s = new ShopScreen();
	int id;
	ShoppingService ss;
	
	public PaymentScreen(PaymentService p , ShoppingService ss) {
		this.p = p;
		this.ss = ss;
	}
	
	
	public void askUser(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Proceed for payment?		press 1");
		System.out.println("Continue Shopping?			press 2");
		System.out.println("enter your choice");
		int choice = sc.nextInt();
		if(choice==1)
			payScreen();
		if(choice==2)
			s.operations();
	}
	public void payScreen(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Payment options");
		System.out.println("Pay by card			1");
		System.out.println("Cash on delivery	2");
		System.out.println("Enter your option");
		int option = sc.nextInt();
		p.insertpay(option);
	}
	
}