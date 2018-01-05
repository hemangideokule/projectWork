package net.bp.onlineshoppingBackend.controller;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import net.bp.onlineshoppingBackend.dto.Address;
import net.bp.onlineshoppingBackend.dto.Cart;
import net.bp.onlineshoppingBackend.dto.CartItem;
import net.bp.onlineshoppingBackend.dto.OrderItem;
import net.bp.onlineshoppingBackend.dto.Orders;
import net.bp.onlineshoppingBackend.dto.User;

public class CartModel implements Serializable
{

	private int addressid;
	private Cart cart;
	private User user;
	private Address address;
	private OrderItem orderItem;
	private Orders order;
	private Set<CartItem> cartItemList;
	 public CartModel() {
		cart=new Cart();
		user=new User();
		address=new Address();
		orderItem=new OrderItem();
		order=new Orders();
		cartItemList=new HashSet<CartItem>();
	}
	public int getAddressid() {
		return addressid;
	}
	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public OrderItem getOrderItem() {
		return orderItem;
	}
	public void setOrderItem(OrderItem orderItem) {
		this.orderItem = orderItem;
	}
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	public Set<CartItem> getCartItemList() {
		return cartItemList;
	}
	public void setCartItemList(Set<CartItem> cartItemList) {
		this.cartItemList = cartItemList;
	}
}