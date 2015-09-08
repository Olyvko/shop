package com.olyvko.shop.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "PRODUCT_CATEGORY")
public class ProductCategory {
	/**
	 * Id field. It's PK and must be generated value. Mapped on column ID.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	/**
	 * categoryName field with PRODUCT_CATEGORY.
	 */

	@NotNull
	@Column(name = "CATEGORY_NAME", length = 250)
	private String categoryName;

	/**
	 * categoryImagePath field with PRODUCT_CATEGORY.
	 */

	@NotNull
	@Column(name = "CATEGORY_IMAGE_PATH", length = 250)
	private String categoryImagePath;

	/**
	 * One-to-many relationship connection with Product table.
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "productCategory")
	private Set<Product> products = new HashSet<Product>();
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets value of products field.
	 * 
	 * @return products
	 */
	public Set<Product> getProducts() {
		return products;
	}

	/**
	 * Sets products field.
	 * 
	 * @param products
	 *            value for products field
	 */
	public void setProducts(Set<Product> products) {
		this.products = products;
	}


	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryImagePath() {
		return categoryImagePath;
	}

	public void setCategoryImagePath(String categoryImagePath) {
		this.categoryImagePath = categoryImagePath;
	}

	@Override
	public String toString() {
	    return "Cateor ["
		    + (id != null ? "id=" + id + ", " : "")
		    + (categoryName != null ? "categoryname=" + categoryName + ", " : "")
		    + "]";
	}
	
}
