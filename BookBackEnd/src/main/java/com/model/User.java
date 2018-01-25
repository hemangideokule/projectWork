package com.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.stereotype.Component;

@Component
@Entity
public class User  implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id

	
	private String password;
	@NotNull
	private String name;
	@Email(message="Enter valid Email")
	private String email;
	private String role;
	private String address;
	@Pattern(regexp="[\\d] {10}", message="Enter Valid Digits")
	@Size(min=8,max=10, message="Enter valid numbers for phone")
	private String phone;
	private boolean enabled;
	
public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}