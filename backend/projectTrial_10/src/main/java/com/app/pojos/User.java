package com.app.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;//JPA : Java EE specs

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

//user : one , parent , inverse : since DOES NOT FK

@Entity
@Table(name = "users_tbl")
public class User extends BaseEntity {
	@Column(length = 20)
	private String firstName;
	@Column(length = 20)
	private String lastName;
	@Column(length = 30,unique=true) 
	private String email;
	
	@Column(length = 10) 
	private String mobNo;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@Column(length = 20, nullable = false)
	private String password;
	
	@Enumerated(EnumType.STRING) 
	@Column(name = "user_role", length = 20)
	private Role userRole;
	
	
	
	
	@JsonIgnore
	@Embedded // OPTIONAL : added only for understanding purpose
	private AadharCard aadharCard;
	// User 1----->* PaymentCard => uni dir asso between Entity n collection of
	// Composite value type
	@ElementCollection // Mandatory o.w : HIb throws MappingExc
	@CollectionTable(name = "payment_cards", 
	joinColumns = @JoinColumn(name = "user_id"))
	private List<PaymentCard> paymentCards = new ArrayList<>();

	// User 1--->1 Cart
	@JsonIgnore
		@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
		private Cart cart;
		// User 1--->1 AadharCard => uni dir asso between Entity n Composite value type
		
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	

	public User(String firstName, String lastName, String email, String mobNo, String password,
			AadharCard aadharCard) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobNo = mobNo;
		this.password = password;
		this.userRole = Role.CUSTOMER;
		this.aadharCard = aadharCard;
	}



	public String getMobNo() {
		return mobNo;
	}



	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
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



	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	// add a helper method to establish bi dir link between User n Cart
	public void addCart(Cart cart){
		this.setCart(cart);// parent ---> child
		cart.setCustomer(this);// child ---> parent
	}
	
	public void addAdharCard(AadharCard card){
		this.setAadharCard(card);// parent ---> child
		//aadharCard.set(this);// child ---> parent
	}

	public AadharCard getAadharCard() {
		return aadharCard;
	}

	public void setAadharCard(AadharCard aadharCard) {
		this.aadharCard = aadharCard;
	}

//	public List<PaymentCard> getPaymentCards() {
//		return paymentCards;
//	}
//
//	public void setPaymentCards(List<PaymentCard> paymentCards) {
//		this.paymentCards = paymentCards;
//	}

	@Override
	public String toString() {
		return "User Id " + getId() + " [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", userRole=" + userRole +  "]";
	}

}
