package com.app.user;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "student")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {
	private int id;
	private String firstName,lastName,contactEmail,address;
	private List<String> modules; 
	
	public Student() {
	}
	
	public Student(int id, String firstName, String lastName, String contactEmail, String address,
			List<String> modules) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactEmail = contactEmail;
		this.address = address;
		this.modules = modules;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public List<String> getModules() {
		return modules;
	}

	public void setModules(List<String> modules) {
		this.modules = modules;
	}
	
}
