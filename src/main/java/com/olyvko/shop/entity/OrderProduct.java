package com.olyvko.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonManagedReference;

/**
 * Represents bean class for OrderProduct entity.
 * 
 */
@Entity
@Table(name = "ORDER_PRODUCTS")
public class OrderProduct {

	/**
	 * Id field. It's PK and must be generated value. 
	 */
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * quantity field. Mapped on column QUANTITY.
	 */
	@Column(name = "QUANTITY")
	private Long quantity;
	
	/**
	 * price field with PRICE.
	 */

	@NotNull
	@Column(name = "PRICE")
	private Long price;

	/**
	 * Many to one connection with Order table.
	 */
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "ORDER_ID")
	private Order order;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID")
    @JsonBackReference
	private Product product;

	/**
	 * Confirm password field.
	 */
	@JsonBackReference
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}
	

}
