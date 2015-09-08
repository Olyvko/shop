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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonManagedReference;

/**
 * Represents bean class for Products entity. Mapped on table Products.
 * 
 */
@Entity
@Table(name = "PRODUCT")
public class Product {
	/**
	 * Id field. It's PK and must be generated value. Mapped on column ID.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	/**
	 * productName field with Product.
	 */

	@NotNull
	@Column(name = "PRODUCT_NAME", length = 250)
	private String productName;
	
	/**
	 * productPrice field with Product.
	 */

	@NotNull
	@Column(name = "PRODUCT_PRICE")
	private Long productPrice;

	/**
	 * productImage field with Product.
	 */

	@NotNull
	@Column(name = "PRODUCT_IMAGE", length = 250)
	private String productImage;

	/**
	 * productDescription field with Product.
	 */

	@NotNull
	@Column(name = "PRODUCT_DESCRIPTION", length = 250)
	private String productDescription;

	@NotNull
    @Column(name = "DATA", unique = false, nullable = false, length = 100000)
    private byte[] data;
	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	/**
	 * Many to one connection with ProductCategory table.
	 */
	@ManyToOne
	@JoinColumn(name = "PRODUCT_CATEGORY_ID")
	private ProductCategory productCategory;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "product") 
	@Column(nullable = true)
    @JsonManagedReference
	private Set<OrderProduct> orderProducts = new HashSet<OrderProduct>();
		
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Long productPrice) {
		this.productPrice = productPrice;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	/**
	 * Gets value of products field.
	 * 
	 * @return products
	 */
	public Set<OrderProduct> getOrderProducts() {
		return orderProducts;
	}

	/**
	 * Sets products field.
	 * 
	 * @param products
	 *            value for products field
	 */
	public void setOrderProducts(Set<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}
	
	@Override
	public String toString() {
	    return "prod ["
		    + (id != null ? "id=" + id + ", " : "")
		    + (productName != null ? "productName=" + productName + ", " : "")
		    + "]";
	}
	
	

}
