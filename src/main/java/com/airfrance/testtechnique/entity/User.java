package com.airfrance.testtechnique.entity;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * A class of user
 * 
 * @author hichem.bouhlel
 */

@Document
public class User {

	@Id
	private ObjectId id;

	@Field("first_name")
	private String firstName;

	@Field("last_name")
	private String lastName;

	@Field("birth_day")
	private Date birthDay;

	private String phoneNumber;

	@Field("address")
	private String address;

	@Field("date_registration")
	private Date dateRegistration;

	/**
	 * Class constructor.
	 */
	public User() {
		this.id = ObjectId.get();
	}

	public ObjectId getId() {
		return id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public Date getDateRegistration() {
		return dateRegistration;
	}

	public void setDateRegistration(Date dateRegistration) {
		this.dateRegistration = dateRegistration;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
