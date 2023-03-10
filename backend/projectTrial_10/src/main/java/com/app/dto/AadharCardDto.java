package com.app.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

 
public class AadharCardDto {

	private String cardNumber;

	private String location;
	
	private LocalDate dob;

	public String getCardNumber() {
		return cardNumber;
	}

	@Override
	public String toString() {
		return "AadharCardDto [cardNumber=" + cardNumber + ", location=" + location + ", dob=" + dob + "]";
	}

	public AadharCardDto(String cardNumber, String location, LocalDate dob) {
		super();
		this.cardNumber = cardNumber;
		this.location = location;
		this.dob = dob;
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

	public AadharCardDto() {
		
	}

	

}
