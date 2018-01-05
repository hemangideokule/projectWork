package net.bp.onlineshoppingBackend.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.bp.onlineshoppingBackend.dao.AddressDAO;
import net.bp.onlineshoppingBackend.dao.UserDAO;
import net.bp.onlineshoppingBackend.dto.Address;
import net.bp.onlineshoppingBackend.dto.Cart;
import net.bp.onlineshoppingBackend.dto.User;

@Component
public class RegisterHandler {
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private AddressDAO addressDAO;

	// if you have a separate model
	public RegisterModel initFlow() {
		return new RegisterModel();
	}

	public String saveUser(RegisterModel registerModel, User user) {
		registerModel.setUser(user);
		return null;

	}

	public String saveAddress(RegisterModel registerModel, Address address) {
		registerModel.setBillingAddress(address);
		return null;
	}

	public void saveRegistrationDetails(RegisterModel registerModel) {
		User user = registerModel.getUser();
		
		// save the user userDAO.add(user);
		Address billingAddress = registerModel.getBillingAddress();
		
		// set the user
		billingAddress.setUser(user);
		Set<Address> address = new HashSet<Address>();
		address.add(billingAddress);
		user.setAddress(address);
		
		// save the billing address
		
		userDAO.add(user);
		
		Cart cart = new Cart(); // set the user
		cart.setUser(user); // save the cart 
		user.setCart(cart);
		userDAO.update(user);
		
		
	}
	// if user is not supplier
	
	 /* if (user.getRole().equals("CUSTOMER")) { 
		  Cart cart = new Cart(); // set the user
		  cart.setUser(user); // save the cart 
		  userDAO.addUserCart(cart);
	  }*/
	 
}
