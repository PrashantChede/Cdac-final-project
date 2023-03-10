package com.app.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;//JPA : Java EE specs

import com.app.pojos.Role;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

//user : one , parent , inverse : since DOES NOT FK


public class CustomerDto{
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String mobNo;
	
	private String password;
	
	private Role userRole;
	
	private String cardNumber;
	
	@Override
	public String toString() {
		return "CustomerDto [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", mobNo="
				+ mobNo + ", password=" + password + ", userRole=" + userRole + ", cardNumber=" + cardNumber
				+ ", location=" + location + ", dob=" + dob + "]";
	}


	public CustomerDto(String firstName, String lastName, String email, String mobNo, String password,
			String cardNumber, String location, LocalDate dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobNo = mobNo;
		this.password = password;
		this.cardNumber = cardNumber;
		this.location = location;
		this.dob = dob;
		this.userRole = Role.CUSTOMER;
	}


	private String location;
	
	private LocalDate dob;


	public CustomerDto() {
		// TODO Auto-generated constructor stub
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMobNo() {
		return mobNo;
	}


	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Role getUserRole() {
		return userRole;
	}


	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}


	public String getCardNumber() {
		return cardNumber;
	}


	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public LocalDate getDob() {
		return dob;
	}


	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	
	




	
}
