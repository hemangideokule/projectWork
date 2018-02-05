package com.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

//import org.springframework.stereotype.Component;


//@Component
@Entity
public class Cart  implements Serializable

{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;
	private int totalItems;
	private double grandTotal;
	
	
/*    @OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name="email")
	private User user;*/
	
	@OneToOne(cascade = CascadeType.PERSIST,fetch=FetchType.EAGER)
	@JoinColumn(name="id")
	private User user;
	
	@OneToMany(targetEntity=CartItem.class,fetch=FetchType.EAGER,mappedBy="cart")
	/*@JoinColumn(name="id")*/
	private Set<CartItem> cartItem=new HashSet<CartItem>();



	public Cart()
	{
		System.out.println("cart constructor");
	}
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getTotalItems() {
		return totalItems;
	}
	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}
	public double getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Set<CartItem> getCartItem() {
		return cartItem;
	}
	public void setCartItem(Set<CartItem> cartItem) {
		this.cartItem = cartItem;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", totalItems=" + totalItems + ", grandTotal=" + grandTotal +"]";
	}


}




	
	

