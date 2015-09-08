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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * Represents bean class for User entity. Mapped on table USERS.
 *
 */
@Entity
@Table(name = "USERS")
public class User {

	/**
	 * Id field. It's PK and must be generated value. Mapped on column ID.
	 */
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * Firstname field. Mapped on column FIRSTNAME.
	 */
	@Column(name = "FIRSTNAME", length = 50)
	private String firstname;

	

	/**
	 * Lastname field. Mapped on column LASTNAME.
	 */
	@Column(name = "LASTNAME", length = 50)
	private String lastname;

	/**
	 * Email field. Shouldn't be empty or null. Mapped on column EMAIL.
	 */
	@NotNull
	@Column(name = "EMAIL", length = 50)
	private String email;

	/**
	 * Login field. Shouldn't be empty or null. Mapped on column LOGIN.
	 */
	@NotNull
	@Column(name = "LOGIN", length = 50)
	private String login;

	/**
	 * Password field. Shouldn't be empty or null. Mapped on column PASSWORD.
	 */
	@NotNull
	@Column(name = "PASSWORD", length = 100)
	private String password;

	/**
	 * Confirm password field.
	 */
	@Transient
	private String confirmPassword;

	/**
	 * Active field. Mapped on column ACTIVE.
	 */
	@Column(name = "ACTIVE")
	private Boolean active;
	
	
	/** Profile photo URL.  Mapped on column PHOTO.*/
	@Column(name = "PHOTO", length = 100)
	private String photo;

	/**
	 * Address field. Shouldn't be empty or null. Mapped on column Address.
	 */
	@NotNull
	@Column(name = "ADDRESS", length = 250)
	private String address;


	/**
	 * Roles collections for many-to-many relations support. Mapped on table
	 * USERS_ROLES.
	 */
	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "USERS_ROLES", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = { @JoinColumn(name = "ROLE_ID") })
	private Set<Role> roles = new HashSet<Role>();

	/**
	 * One-to-many relationship connection with Orders table.
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user")
	private Set<Order> orders = new HashSet<Order>();

	/**
	 * Default constructor.
	 */
	public User() {

	}

	/**
	 * Parameterized constructor.
	 * 
	 */
	public User(String firstname, String lastname, String email, String login,
			String password, Boolean active, Set<Role> roles) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.login = login;
		this.password = password;
		this.active = active;
		this.roles = roles;
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
	 * Gets value of firstname field.
	 * 
	 * @return firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Sets firstname field.
	 * 
	 * @param firstname
	 *            value for firstname field
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * Gets value of lastname field.
	 * 
	 * @return lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * Sets lastname field.
	 * 
	 * @param lastname
	 *            value for lastname field
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * Gets value of email field.
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets email field.
	 * 
	 * @param email
	 *            value for email field
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets value of password field.
	 * 
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets password field.
	 * 
	 * @param password
	 *            value for password field
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the confirmPassword
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}

	/**
	 * @param confirmPassword
	 *            the confirmPassword to set
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	/**
	 * Gets value of login field.
	 * 
	 * @return login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Sets login field.
	 * 
	 * @param login
	 *            value for login field
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Gets value of roles field.
	 * 
	 * @return roles
	 */
	public Set<Role> getRoles() {
		return roles;
	}

	/**
	 * Sets roles field.
	 * 
	 * @param roles
	 *            roles set for roles field
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}


	/**
	 * Gets state of active field.
	 * 
	 * @return active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * Sets active field.
	 * 
	 * @param active
	 *            value for active field
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * Gets value of photo field.
	 * 
	 * @return photo
	 */
	public String getPhoto() {
	    return photo;
	}

	/**
	 * Sets photo field.
	 * 
	 * @param photo
	 *            value for photo field
	 */
	public void setPhoto(String photo) {
	    this.photo = photo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * Gets value of products field.
	 * 
	 * @return products
	 */
	public Set<Order> getOrders() {
		return orders;
	}

	/**
	 * Sets products field.
	 * 
	 * @param products
	 *            value for products field
	 */
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
	@Override
	public String toString() {
	    return "User ["
		    + (id != null ? "id=" + id + ", " : "")
		    + (firstname != null ? "firstname=" + firstname + ", " : "")
		    + (lastname != null ? "lastname=" + lastname + ", " : "")
		    + (email != null ? "email=" + email + ", " : "")
		    + (login != null ? "login=" + login + ", " : "")
		    + (active != null ? "active=" + active + ", " : "")
		    + (address != null ? "address=" + address + ", " : "")
		    + (photo != null ? "photo=" + photo + ", " : "")
		    + (password != null ? "password=" + password + ", " : "")
		    + "]";
	}
	

}

