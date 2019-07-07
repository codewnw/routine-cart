package com.routinecart.model;



public class Product {

   
   
    @Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", productUrl=" + productUrl + ", price=" + price + "]";
	}



	public Product(Long id, String name, String productUrl, String price) {
		super();
		this.id = id;
		this.name = name;
		this.productUrl = productUrl;
		this.price = price;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getProductUrl() {
		return productUrl;
	}



	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}



	public String getPrice() {
		return price;
	}



	public void setPrice(String price) {
		this.price = price;
	}



	private Long id;
  
    private String name;
    
    private String productUrl;
   
    private String price;

	

    public Product() {
    }

 
}
