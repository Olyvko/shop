package com.olyvko.shop.entity;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Represents bean class for Role entity. Mapped on table ROLES.
 * 
 */
@Entity
@Table(name = "ROLES")
public class Role {

	/**
	 * Id field. It's PK and must be generated value. Mapped on column ID.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	/**
	 * Name field. Shouldn't be empty or null. Mapped on column NAME.
	 */
	@NotNull
	@Column(name = "NAME", length = 50)
	private String name;

	/**
	 * Users collections for many-to-many relations support. Mapped on table
	 * USERS_ROLES.
	 */
	@ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
	private Set<User> users = new HashSet<User>();

	/**
	 * Default constructor.
	 */
	public Role() {

	}

	/**
	 * Parameterized constructor.
	 * 
	 * @param name
	 *            value for name field
	 */
	public Role(String name) {
		this.name = name;
	}

	/**
	 * Gets value of id field.
	 * 
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets id field.
	 * 
	 * @param id
	 *            value for id field
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets value of name field.
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets name field.
	 * 
	 * @param name
	 *            value for name field
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets value of users field.
	 * 
	 * @return users
	 */
	public Set<User> getUsers() {
		return users;
	}

	/**
	 * Sets user field.
	 * 
	 * @param users
	 *            users set for user field
	 */
	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
