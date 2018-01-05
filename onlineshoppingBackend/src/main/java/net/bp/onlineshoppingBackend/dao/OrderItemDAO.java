package net.bp.onlineshoppingBackend.dao;

import java.util.List;

import net.bp.onlineshoppingBackend.dto.OrderItem;

public interface OrderItemDAO {

	OrderItem get(int id);
	List<OrderItem> list();
	boolean add(OrderItem orderItem);
	boolean update(OrderItem orderItem);
	void delete(int id);
	//public OrderItem getCartByUserId(int userId); 
	//public OrderItem getCartByUserIdAndProduct(int userId, int productId); 
}
