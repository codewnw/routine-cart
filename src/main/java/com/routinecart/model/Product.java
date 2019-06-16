package com.routinecart.model;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rc_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "productUrl")
    private String productUrl;
    @Column(name = "price")
    private String price;

	public Product(Long id, String name, String productUrl, String price, Category categories) {
		super();
		this.id = id;
		this.name = name;
		this.productUrl = productUrl;
		this.price = price;
		this.categories = categories;
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

	public Category getCategories() {
		return categories;
	}

	public void setCategories(Category categories) {
		this.categories = categories;
	}

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categories_id", referencedColumnName = "categories_id")
   private Category categories;

    public Product() {
    }

 
}
