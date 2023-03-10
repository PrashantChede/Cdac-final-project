package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable // to tell hibernate following class is a composite value type , whose contents
			// have to eb embedded in the owning entity. It doesn't have a separate
			// existence
public class AadharCard {
	@Column(name="card_no",unique = true,length = 20)
	private String cardNumber;
	@Column(length = 50)
	private String location;
	
	private LocalDate dob;

	public AadharCard() {
		// TODO Auto-generated constructor stub
	}

	public AadharCard(String cardNumber, String location, LocalDate dob) {
		super();
		this.cardNumber = cardNumber;
		this.location = location;
		this.dob = dob;
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

	@Override
	public String toString() {
		return "AadharCard [cardNumber=" + cardNumber + ", location=" + location + ", dob=" + dob + "]";
	}

}
