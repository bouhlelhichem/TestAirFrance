package com.airfrance.testtechnique.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import com.airfrance.testtechnique.annotations.Adult;
import com.airfrance.testtechnique.annotations.France;

/**
 * A class DTO to user
 * 
 * @author hichem.bouhlel
 */
public class UserDTO {

	@Id
	private ObjectId id;

	@NotNull(message = "firstName is a required field")
	private String firstName;

	@NotNull(message = "lastName is a required field")
	private String lastName;

	private String phoneNumber = "01234567890";

	@NotNull(message = "birthDay is a required field")
	@Adult
	private Date birthDay;

	@NotNull(message = "address is a required field")
	@France
	private String address;

	private Date dateRegistration;

	/**
	 * Class constructor for user DTO.
	 * 
	 * @param firstName
	 * @param lastName
	 * @param phoneNumber
	 * @param birthDay
	 * @param address
	 * @param dateRegistration
	 */
	public UserDTO(@NotNull(message = "firstName is a required field") String firstName,
			@NotNull(message = "lastName is a required field") String lastName, String phoneNumber,
			@NotNull(message = "birthDay is a required field") Date birthDay,
			@NotNull(message = "address is a required field") String address, Date dateRegistration) {
		super();
		this.id = ObjectId.get();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.birthDay = birthDay;
		this.address = address;
		this.dateRegistration = dateRegistration;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber="
				+ phoneNumber + ", birthDay=" + birthDay + ", address=" + address + ", dateRegistration="
				+ dateRegistration + "]";
	}

}
