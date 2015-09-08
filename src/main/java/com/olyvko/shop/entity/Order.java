package com.olyvko.shop.entity;

import java.util.Date;
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

/**
 * Represents bean class for Order entity. 
 * 
 */
@Entity
@Table(name = "ORDERS")
public class Order {
	/**
	 * Id field. It's PK and must be generated value. Mapped on column ID.
	 */
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * ordername field. Mapped on column ORDERNAME.
	 */
	@Column(name = "ORDER_NAME", length = 150)
	private String orderName;
	
	/**
	 * ordercity field. Mapped on column ORDERCITY.
	 */
	@Column(name = "ORDER_CITY", length = 150)
	private String orderCity;

	/**
	 * Date of test creation. Mapped on column DATE.
	 */
	@Column(name = "ORDER_DATE")
	private Date orderDate;
	
	/**
	 * Many to one connection with User table.
	 */
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;

	/**
	 * One-to-many relationship connection with OrderProduct table.
	 */
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "order")
	private Set<OrderProduct> orderProducts = new HashSet<OrderProduct>();
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", orderName=" + orderName + ", orderCity="
				+ orderCity + ", orderDate=" + orderDate + ", user=" + user
				+ ", orderProducts=" + orderProducts + "]";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getOrderCity() {
		return orderCity;
	}

	public void setOrderCity(String orderCity) {
		this.orderCity = orderCity;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * Gets value of OrderProduct field.
	 * 
	 * @return OrderProduct
	 */
	public Set<OrderProduct> getOrderProducts() {
		return orderProducts;
	}

	/**
	 * Sets OrderProduct field.
	 * 
	 * @param OrderProduct
	 *            value for OrderProduct field
	 */
	public void setOrderProducts(Set<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}


}
