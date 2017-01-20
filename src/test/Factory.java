package test;

import dbdesign.DBoperations;

public class Factory {
	private static OrderService instance;
	private static ShoppingService ss;
	private static CustomerService cs;
	private static PaymentService ps;
	private Factory() {
	}


	public synchronized static OrderService getOrderService(DBoperations op) {
		if (instance == null) {
			instance = new OrderService(op);
		}
		return instance;
	}

	public synchronized static ShoppingService getShoppingService(DBoperations op) {
		if (ss == null) {
			ss = new ShoppingService(op);
		}
		return ss;
	}
	public synchronized static CustomerService getCustomerService(DBoperations op) {
		if (cs == null) {
			cs = new CustomerService(op);
		}
		return cs;
	}
	public synchronized static PaymentService getPaymentService(DBoperations op) {
		if (ps == null) {
			ps = new PaymentService(op);
		}
		return ps;
	}
}
