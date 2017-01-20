package test;

import java.sql.Statement;

import dbdesign.DBoperations;

public class PaymentService {
	DBoperations op;
	public PaymentService(DBoperations op) {
		this.op = op;
	}
	public void insertpay(int option) {
		Statement stmt=null;

		try
		{
			String sql = null;
			if(option==1){

				 sql = "INSERT INTO payment (paid,patype) "
						+ "VALUES (1, 'pay by card');";
			}
			else{

				  sql = "INSERT INTO payment (paid,patype) "
						+ "VALUES (2, 'cash on delivery');";
			}
			op.insert(sql);
		}catch (Exception e) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			System.exit(0);
		}
	}
}
