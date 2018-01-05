package net.bp.onlineshoppingBackend.controller;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import net.bp.onlineshoppingBackend.dto.Address;
import net.bp.onlineshoppingBackend.dto.User;


public class RegisterModel implements Serializable {

	private static final long serialVersionUID = -1L;
	private User user;
	private Address billingAddress;

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
