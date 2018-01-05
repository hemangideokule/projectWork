package net.bp.onlineshoppingBackend.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.bp.onlineshoppingBackend.dao.AddressDAO;
import net.bp.onlineshoppingBackend.dao.CartDAO;
import net.bp.onlineshoppingBackend.dao.CartItemDAO;
import net.bp.onlineshoppingBackend.dao.OrderDAO;
import net.bp.onlineshoppingBackend.dao.OrderItemDAO;
import net.bp.onlineshoppingBackend.dao.UserDAO;
import net.bp.onlineshoppingBackend.dto.Address;
import net.bp.onlineshoppingBackend.dto.Cart;
import net.bp.onlineshoppingBackend.dto.CartItem;
import net.bp.onlineshoppingBackend.dto.OrderItem;
import net.bp.onlineshoppingBackend.dto.Orders;
import net.bp.onlineshoppingBackend.dto.User;

@Component
public class CartHandler {

	@Autowired
	UserDAO userDAO;
	@Autowired
	HttpServletRequest request;
	@Autowired
	CartDAO cartDAO;
	@Autowired
	AddressDAO addressDAO;
	@Autowired
	CartItemDAO cartItemDAO;
	@Autowired
	OrderDAO orderDAO;
	@Autowired
	OrderItemDAO orderItemDAO;

	public CartModel initFlow() {
		CartModel cartModel = new CartModel();

		// --Retrieve current logged in user details
		Principal p = request.getUserPrincipal();
		User user = userDAO.getUserByUserName(p.getName());
		cartModel.setUser(user);

		cartModel.setCart(user.getCart());
		cartModel.setCartItemList((user.getCart()).getCartItem());
		return cartModel;
	}

	public void saveNewShippingAddress(CartModel cartModel, Address address) {
		address.setUser(cartModel.getUser());
		addressDAO.add(address);
		cartModel.setAddress(address);

	}
	
	public void setShippingAddress(CartModel checkoutModel, int addressid)
	{
		
		System.out.println("shipping address id"+addressid);
		Address address=addressDAO.get(checkoutModel.getAddressid());
		checkoutModel.setAddress(address);
		System.out.println("Shipping Address");
		System.out.println(checkoutModel.getAddressid());
		
	}
	
	public String saveOrder(CartModel cartModel) {
		Orders order = new Orders();
		User user=cartModel.getUser();
		order.setUser(cartModel.getUser());
		order.setAddress(cartModel.getAddress());
		order.setTotalItems(cartModel.getCart().getTotalItems());
		order.setGrandTotal(cartModel.getCart().getGrandTotal());
		//orderDAO.add(order);
		Set<Orders> orderslist=new HashSet<>();
		Set<CartItem> cartItemList = cartModel.getCartItemList();
		List<OrderItem> orderItemList=new ArrayList<>();	

		for (CartItem item : cartItemList) {
			OrderItem orderItem = new OrderItem();
			orderItem.setProduct(item.getProduct());
			orderItem.setQuantity(item.getQuantity());
			orderItem.setTotalPrice(item.getTotalPrice());
			orderItem.setOrder(order);
			orderDAO.add(order);
			orderItemList.add(orderItem);
		}
		order.setOrderItems(orderItemList);
		orderslist.add(order);
		user.setOrders(orderslist);
		orderDAO.add(order);
		
		Cart cart=cartModel.getCart();
		cart.setTotalItems(0);
		cart.setGrandTotal(0);
		cartDAO.update(cart);
		
		cartItemDAO.deleteAllCartItems(cart.getId());
		//wait let me check here again 
		System.out.println("All items deleted");
	return "success";
	}
	
	public Orders getReceipt(CartModel cartModel)
	{
		
		return null;
		
	}
}
