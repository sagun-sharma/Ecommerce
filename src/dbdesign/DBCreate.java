package dbdesign;
import java.sql.*;
public class DBCreate {
	public static void main(String args[]){
		Connection c = null;
		Statement stmt = null;
		{
			try {
				Class.forName("org.postgresql.Driver");
				c = DriverManager
						.getConnection("jdbc:postgresql://localhost:5432/shopping",
								"postgres", "sagun");
				System.out.println("Opened database successfully");

				stmt = c.createStatement();
				String cust = "CREATE TABLE CUSTOMER " +
						"(CID SERIAL PRIMARY KEY     NOT NULL," +
						" CNAME           TEXT    NOT NULL, " +
						" CAGE            INT     NOT NULL, " +
						" CGENDER		 TEXT	 NOT NULL, " +
						" CADDRESS        CHAR(50))";
				stmt.executeUpdate(cust);
				String prod = "CREATE TABLE PRODUCT " +
						"(PID INT PRIMARY KEY     NOT NULL," +
						" PNAME           TEXT    NOT NULL)";
				stmt.executeUpdate(prod);
				String cloth = "CREATE TABLE CLOTHES " +
						"(ID INT PRIMARY KEY     NOT NULL," +
						" BRAND          TEXT    NOT NULL, " +
						" SIZE           TEXT    NOT NULL, " +
						" PRICE          INT)";
				stmt.executeUpdate(cloth);
				String shoes = "CREATE TABLE SHOES " +
						"(ID INT PRIMARY KEY     NOT NULL," +
						" BRAND           TEXT    NOT NULL, " +
						" SIZE           TEXT    NOT NULL, " +
						" PRICE        INT)";
				stmt.executeUpdate(shoes);
				String bags = "CREATE TABLE BAGS " +
						"(ID INT PRIMARY KEY     NOT NULL," +
						" BRAND           TEXT    NOT NULL, " +
						" PRICE        INT)";
				stmt.executeUpdate(bags);
				String order = "CREATE TABLE ORDERR " +
						"(OID INT PRIMARY KEY     NOT NULL," +
						" ONAME           TEXT    NOT NULL, " +
						" ODATE           TEXT    NOT NULL, " +
						" DELDATE	 		TEXT  NOT NULL)";
				stmt.executeUpdate(order);
				String pay = "CREATE TABLE PAYMENT " +
						"(PAID INT PRIMARY KEY     NOT NULL," +
						" PATYPE           TEXT    NOT NULL)";
				stmt.executeUpdate(pay);
				stmt.close();
				c.close();
			} catch ( Exception e ) {
				System.err.println( e.getClass().getName()+": "+ e.getMessage() );
				System.exit(0);
			}
			System.out.println("Table created successfully");
		}
	}
}
