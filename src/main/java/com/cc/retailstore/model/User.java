package com.cc.retailstore.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_users")
public class User extends BaseBean{
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="middle_name")
	private String middleName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="username")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email")
	private String emailAddress;
	
	@Column(name="address")
	private String address;
	
	@ManyToMany
    @JoinTable(name="tbl_user_associations", 
    	joinColumns={@JoinColumn(name="user_id",nullable = false,
    	updatable = false)}, 
    	inverseJoinColumns={@JoinColumn(name="association_id", nullable = false,
    	updatable = false)})
	private List<PercentageDiscount> percentageDiscount;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<PercentageDiscount> getPercentageDiscount() {
		return percentageDiscount;
	}

	public void setPercentageDiscount(List<PercentageDiscount> percentageDiscount) {
		this.percentageDiscount = percentageDiscount;
	}
	
}
