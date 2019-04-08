package com.javafullstackdev.demo.dto;

import java.util.Date;

import com.javafullstackdev.demo.entity.Address;

public class UserDTO {

	private Long id;
	private String email;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private AddressDTO mailingAddress;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public AddressDTO getMailingAddress() {
		return mailingAddress;
	}
	public void setMailingAddress(AddressDTO mailingAddress) {
		this.mailingAddress = mailingAddress;
	}
}
