package dbdesign;

import java.sql.*;

public class DBoperations {
	Connection c = null;

	public DBoperations(DBConnect conn) {
		// TODO Auto-generated constructor stub
		c = conn.getConnection();
	}

	public void insert(String sql) throws SQLException {
		Statement stmt = null;
		try {

			stmt = c.createStatement();

			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		} finally {

			stmt.close();
			c.commit();

		}

		System.out.println("Records created successfully");
	}

	public ResultSet select(String sql) throws SQLException {
		Statement stmt = null;
		ResultSet rs =null;
		try {
			stmt = c.createStatement();
			rs = stmt.executeQuery(sql);

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		finally{
			
			
			
		}
	//	System.out.println("Records created successfully");
		return rs;
		
		

	}
}
