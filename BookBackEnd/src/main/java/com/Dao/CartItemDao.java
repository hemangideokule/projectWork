package com.Dao;

import java.util.List;

import com.model.CartItem;



public interface CartItemDao
{
	CartItem get(int id);
	List<CartItem> list();
	boolean add(CartItem cartItem);
	boolean updateCartItem(CartItem cartItem);
	void delete(int id);
	public CartItem getCartByUserId(int userId); 
	public CartItem getCartByUserIdAndProduct(int userId, int pid); 
	void delete(int cartid,int productid);
	CartItem getCartItemByCartIdAndProductId(int cartId,int pid);
	boolean deleteAllCartItems(int cartid);
}
