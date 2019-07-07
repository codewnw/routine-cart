package com.routinecart.model;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "rc_Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "categories_id")
    private Long id;
    @Column(name = "category")
    private String category;
 

	
    
	//@OneToMany(mappedBy = "categories")
    @OneToMany(cascade = CascadeType.ALL)
	private List<SubCategory> subCategories;

	
	public Category() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public List<SubCategory> getSubCategories() {
		return subCategories;
	}


	public void setSubCategories(List<SubCategory> subCategories) {
		this.subCategories = subCategories;
	}


	@Override
	public String toString() {
		return "Category [id=" + id + ", category=" + category + ", subCategories=" + subCategories + "]";
	}


	public Category(Long id, String category, List<SubCategory> subCategories) {
		super();
		this.id = id;
		this.category = category;
		this.subCategories = subCategories;
	}



  
}
