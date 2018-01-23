package com.model;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.stereotype.Component;

import org.springframework.web.multipart.MultipartFile;

@Component
@Entity
public class Cart  implements Serializable

{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Id
@GeneratedValue 
private int cartId;

private int cartProductId;
@OneToOne(fetch=FetchType.LAZY)
@JoinColumn(name="userMailId")

private User cartUserDetails;
private double cartPrice;
private int cartStock;
private String cartImage;
private String cartProductName;
private int cartQuantity;


public Cart()
{}


public Cart(int cartId, int cartProductId, User cartUserDetails, Double cartPrice, int cartStock, String cartProductName, String userMailId, int cartQuantity)
{
this.cartId=cartId;
//this.cartImage=cartImage;
this.cartPrice=cartPrice;
this.cartProductId=cartProductId;
this.cartProductName=cartProductName;
this.cartUserDetails=cartUserDetails;
this.cartStock=cartStock;
this.cartQuantity=cartQuantity;

	
}


public int getCartId() {
	return cartId;
}


public void setCartId(int cartId) {
	this.cartId = cartId;
}


public int getCartProductId() {
	return cartProductId;
}


public void setCartProductId(int cartProductId) {
	this.cartProductId = cartProductId;
}


public User getCartUserDetails() {
	return cartUserDetails;
}


public void setCartUserDetails(User cartUserDetails) {
	this.cartUserDetails = cartUserDetails;
}


public double getCartPrice() {
	return cartPrice;
}


public void setCartPrice(double cartPrice) {
	this.cartPrice = cartPrice;
}


public int getCartStock() {
	return cartStock;
}


public void setCartStock(int cartStock) {
	this.cartStock = cartStock;
}


public String getCartImage() {
	return cartImage;
}


public void setCartImage(String cartImage) {
	this.cartImage = cartImage;
}


public String getCartProductName() {
	return cartProductName;
}


public void setCartProductName(String cartProductName) {
	this.cartProductName = cartProductName;
}


public int getCartQuantity() {
	return cartQuantity;
}


public void setCartQuantity(int cartQuantity) {
	this.cartQuantity = cartQuantity;
}


}




	
	

