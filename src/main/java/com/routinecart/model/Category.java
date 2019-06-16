package com.routinecart.model;
import java.util.List;

import javax.persistence.*;



@Entity
@Table(name = "rc_Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "categories_id")
    private Long id;
    @Column(name = "name")
    private String name;
 
   // @JoinColumn(name = "COURSE_ID")
	@OneToMany(cascade = CascadeType.ALL)
	private List<Product> products;
 
	public Category(Long id, String name, List<Product> products) {
		super();
		this.id = id;
		this.name = name;
		this.products = products;
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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Category() {
    }



  
}
