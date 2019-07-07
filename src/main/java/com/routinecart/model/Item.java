package com.routinecart.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.routinecart.model.Category;


@Entity
@Table(name = "rc_item")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 @Column(name = "id")
	private Long id;
	@Column(name = "name")
	private String name;

	private String description;

	private String imageUrl;

	private Integer quantity;
	private Double price;
	private String category;
	private String subCategory;
	
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", description=" + description + ", imageUrl=" + imageUrl
				+ ", quantity=" + quantity + ", price=" + price + ", category=" + category + ", subCategory="
				+ subCategory + "]";
	}

	public Item(Long id, String name, String description, String imageUrl, Integer quantity, Double price,
			String category, String subCategory) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.imageUrl = imageUrl;
		this.quantity = quantity;
		this.price = price;
		this.category = category;
		this.subCategory = subCategory;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public Item() {
		super();
	}

	
	

}
