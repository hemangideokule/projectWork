package net.bp.onlineshoppingBackend.dao;

import java.util.List;

import net.bp.onlineshoppingBackend.dto.CartItem;

public interface CartItemDAO {
	CartItem get(int id);
	List<CartItem> list();
	boolean add(CartItem cartItem);
	boolean update(CartItem cartItem);
	void delete(int id);
	public CartItem getCartByUserId(int userId); 
	public CartItem getCartByUserIdAndProduct(int userId, int productId); 
	void delete(int cartid,int productid);
	CartItem getCartItemByCartIdAndProductId(int cartid,int productid);
	boolean deleteAllCartItems(int cartid);
}
