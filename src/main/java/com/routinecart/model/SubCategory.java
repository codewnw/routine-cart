package com.routinecart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "rc_SubCategory")

public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "subcategories_id")
    private Long id;
    @Column(name = "subCategory")
    private String subCategory;
   

	public SubCategory() {
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getSubCategory() {
		return subCategory;
	}


	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}


	public SubCategory(Long id, String subCategory) {
		super();
		this.id = id;
		this.subCategory = subCategory;
	}


	@Override
	public String toString() {
		return "SubCategory [id=" + id + ", subCategory=" + subCategory + "]";
	}


	

}
