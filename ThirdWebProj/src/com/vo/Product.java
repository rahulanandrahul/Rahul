package com.vo;

public class Product {

	
	private int productid;
	private String productname;
	private int productprice;
	private String productdescription;
	
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(int productid, String productname, int productprice, String productdescription) {
		super();
		this.productid = productid;
		this.productname = productname;
		this.productprice = productprice;
		this.productdescription = productdescription;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public int getProductprice() {
		return productprice;
	}

	public void setProductprice(int productprice) {
		this.productprice = productprice;
	}

	public String getProductdescription() {
		return productdescription;
	}

	public void setProductdescription(String productdescription) {
		this.productdescription = productdescription;
	}


}
