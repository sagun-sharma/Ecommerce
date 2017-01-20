package test;

import dbdesign.DBoperations;

public class OrderService {
	DBoperations op;
	public OrderService(DBoperations op) {
		this.op = op;
	}
	public boolean insertorder(String id) {
		//insert this order in order table
		try
		{
			String sql = "INSERT INTO orderr (oid,oname,odate,deldate) "
					+ "VALUES (4,'" + id + "', '19jan', '30jan')";
			op.insert(sql);

		}catch (Exception e) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			System.exit(0);
		}
		return true;
	}
}
