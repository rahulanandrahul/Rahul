package com.dao;


import java.security.KeyStore.ProtectionParameter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.vo.Product;

public class ProductDao extends ConnectionDao {

 	
	public void deleteById(int id ) throws ClassNotFoundException, SQLException{
		
		int pid=id;
		
		String str="delete from product where pid=?";
		
		Connection connection=null;
		 
		connection= getConn();

		PreparedStatement preparedStatement= connection.prepareStatement(str);
		
       		preparedStatement.executeUpdate();
	}
	
	public List<Product> allProducts(){
		
		LinkedList<Product> allproducts = new LinkedList<>();
		
		String str="select * from product";
		
		//Connection connection=getConn();
	
		try{
		Connection connection=getConn();
		
		Statement statement = connection.createStatement();
		
		ResultSet resultSet = statement.executeQuery(str);
		
		while(resultSet.next())
		{
			Product product = new Product();
			
			product.setProductid(resultSet.getInt(1));			
			product.setProductname(resultSet.getString(2));			
			product.setProductprice(resultSet.getInt(3));
			product.setProductdescription(resultSet.getString(4));

			allproducts.add(product);
		}
		
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		return allproducts;
	}
	
	public void register(Product product) throws SQLException{
	
	
	String str="Insert into product (productid,productname,productprice,productdescription) values (?,?,?,?)";
	
	Connection connection=null;
	
	try {
		connection=getConn();
		
		PreparedStatement preparedStatement= connection.prepareStatement(str);
		
		preparedStatement.setInt(1,product.getProductid());
		preparedStatement.setString(2,product.getProductname());
		preparedStatement.setInt(3,product.getProductprice());		
		preparedStatement.setString(4,product.getProductdescription());
	
		int i=preparedStatement.executeUpdate();
		 
		if (i>0) {
			System.out.println("Record Insertion Successful");
		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 	
	finally {
		if(connection!= null){
		connection.close();
	}
	}
	
	}
	
}
