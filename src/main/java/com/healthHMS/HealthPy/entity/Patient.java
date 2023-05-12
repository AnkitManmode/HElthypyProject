package com.healthHMS.HealthPy.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CollectionId;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Patient {

	@Id
	@Column(name="Id" , nullable=false)
	private  String id;
	
	@Column(name="FirstName",nullable=false)
	@NotBlank(message="FirstName is Required")
	private String firstName;
	
	@Column(name="LastName",nullable=false)
	@NotBlank(message="LastName is Required")
	private String lastName;
	
	@Column(name="EmailId",nullable=false)
	@NotBlank(message="EmailId is Required")
	private String emailId;
	
	@Column(name="Age",nullable=false)
	@NotBlank(message="Age is Required")
	private int age;
	
	@Column(name="BloodGroup",nullable=false)
	@NotBlank(message="BloodGroup is Required")
	private String bloodGroup;
	
	@Column(name="MobileNumber",nullable=false)
	@NotBlank(message="MobileNumber is Required")
	private String mobileNumber;
	
	@Column(name="Street",nullable=false)
	@NotBlank(message="Street is Required")
	private String street;
	
	@Column(name="City",nullable=false)
	@NotBlank(message="City is Required")
	private String city;
	
	@Column(name="Pincode",nullable=false)
	@NotBlank(message="Pincode is Required")
	private String pincode;
	
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name="RegisterDate")
	private Date registerDate;
	
	public Patient() {
		// TODO Auto-generated constructor stub
	}

	public Patient(String id, String firstName, String lastName, String emailId, int age, String bloodGroup,
			String mobileNumber, String street, String city, String pincode, Date registerDate) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.age = age;
		this.bloodGroup = bloodGroup;
		this.mobileNumber = mobileNumber;
		this.street = street;
		this.city = city;
		this.pincode = pincode;
		this.registerDate = registerDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ ", age=" + age + ", bloodGroup=" + bloodGroup + ", mobileNumber=" + mobileNumber + ", street="
				+ street + ", city=" + city + ", pincode=" + pincode + ", registerDate=" + registerDate + "]";
	}
	
	
	
}
