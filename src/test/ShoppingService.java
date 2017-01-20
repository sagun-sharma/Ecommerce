package test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.guavus.training.pojo.Catalogue;

import dbdesign.DBConnect;
import dbdesign.DBoperations;

public class ShoppingService {
	DBoperations op ;
	public ShoppingService(DBoperations op) {

		this.op =op;
	}

	public  ArrayList<Catalogue> listProducts(int productType){

		ArrayList<Catalogue> products = new ArrayList<Catalogue>();
		//query data base and find all the propducts of the type
		// convert result set to prodyct and add to a list
		String sql = "select * from catalogue where producttype = " + productType;
		try {
			ResultSet rs = op.select(sql);
			System.out.println(rs);
			while (rs.next()) {
				products.add(new Catalogue(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5))) ;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int temp= products.size();
		return products;

	}



	public static void showProductScreen(int productType) {

		List<Catalogue> products =Factory.getShoppingService(new DBoperations(new DBConnect())).listProducts(productType);
		int temp= products.size();
		for(int i=0;i<temp;i++){
			System.out.println("\t "+ products.get(i));
		}
		ShopScreen.takeorder();
	}
}



