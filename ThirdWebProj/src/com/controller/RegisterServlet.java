package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductDao;
import com.vo.Product;

@WebServlet("/registerProcess")
public class RegisterServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Product product=new Product();
	
		product.setProductid(Integer.parseInt(request.getParameter("productid")));
		product.setProductname(request.getParameter("productname"));
		product.setProductprice(Integer.parseInt(request.getParameter("productprice")));
		product.setProductdescription(request.getParameter("productdescription"));
		
		ProductDao dao= new ProductDao();
		try {
			dao.register(product);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		PrintWriter out= response.getWriter();
		
		out.println("Successfully Registered");
		
	}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
